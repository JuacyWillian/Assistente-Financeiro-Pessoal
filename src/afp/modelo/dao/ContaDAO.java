package afp.modelo.dao;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.util.ContaTipo;
import afp.util.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private final FabricaDeConexoes fabrica;

    public ContaDAO() {
        fabrica = new FabricaDeConexoes();
    }

    public void insert(Conta c) {
        String sql = "INSERT INTO contas("
                + "titulo, descricao, cat_id, tipo, valor, dt_criacao, dt_vencimento, quitado) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getDescricao());
            ps.setInt(3, c.getCategoria().getId());
            ps.setString(4, c.getTipo().name());
            ps.setLong(5, c.getValor());
            ps.setDate(6, Date.valueOf(c.getDtCriacao()));
            ps.setDate(7, Date.valueOf(c.getDtVencimento()));
            ps.setBoolean(8, c.isQuitado());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Conta c) {
        String sql = "UPDATE contas "
                + "SET (titulo=?, descricao=?, cat_id=?, tipo=?, "
                + "valor=?, dt_criacao=?, dt_vencimento=?, quitado=?) "
                + "WHERE contas.id=?;";
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getDescricao());
            ps.setInt(3, c.getCategoria().getId());
            ps.setString(4, c.getTipo().name());
            ps.setLong(5, c.getValor());
            ps.setDate(6, Date.valueOf(c.getDtCriacao()));
            ps.setDate(7, Date.valueOf(c.getDtVencimento()));
            ps.setBoolean(8, c.isQuitado());
            ps.setInt(9, c.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Conta c) {
        String sql = "DELETE from contas where contas.id=?";
        List<Conta> contaList = new ArrayList();
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, c.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Conta> findAll() {
        String sql = "select * from contas "
                + "LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        List<Conta> contaList = new ArrayList();
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                c.setId(rs.getInt("contas.id"));
                c.setTitulo(rs.getString("contas.titulo"));
                c.setDescricao(rs.getString("contas.descricao"));

                Categoria cat = new Categoria();
                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));

                c.setCategoria(cat);
                c.setTipo(ContaTipo.valueOf(rs.getString("contas.tipo")));
                c.setValor(rs.getLong("contas.valor"));
                c.setDtCriacao(rs.getDate("contas.dt_criacao").toLocalDate());
                c.setDtVencimento(rs.getDate("contas.dt_vencimento").toLocalDate());
                c.setQuitado(rs.getBoolean("contas.quitado"));

                contaList.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return contaList;
    }

    public Conta findById(int id) {
        String sql = "select * from contas where contas.id=? "
                + "LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                c.setId(rs.getInt("contas.id"));
                c.setTitulo(rs.getString("contas.titulo"));
                c.setDescricao(rs.getString("contas.descricao"));

                Categoria cat = new Categoria();
                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));

                c.setCategoria(cat);
                c.setTipo(ContaTipo.valueOf(rs.getString("contas.tipo")));
                c.setValor(rs.getLong("contas.valor"));
                c.setDtCriacao(rs.getDate("contas.dt_criacao").toLocalDate());
                c.setDtVencimento(rs.getDate("contas.dt_vencimento").toLocalDate());
                c.setQuitado(rs.getBoolean("contas.quitado"));

                return c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Conta> findByCategoria(Categoria cat) {
        String sql = "SELECT * FROM contas WHERE cat_id=?; "
                + "LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        List<Conta> contas = new ArrayList();
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, cat.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                c.setId(rs.getInt("contas.id"));
                c.setTitulo(rs.getString("contas.titulo"));
                c.setDescricao(rs.getString("contas.descricao"));

                c.setCategoria(cat);
                c.setTipo(ContaTipo.valueOf(rs.getString("contas.tipo")));
                c.setValor(rs.getLong("contas.valor"));
                c.setDtCriacao(rs.getDate("contas.dt_criacao").toLocalDate());
                c.setDtVencimento(rs.getDate("contas.dt_vencimento").toLocalDate());
                c.setQuitado(rs.getBoolean("contas.quitado"));

                contas.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contas;
    }

    public List<Conta> findQuitadas() {
        String sql = "SELECT * FROM contas LEFT JOIN categorias "
                + "ON contas.cat_id=categorias.id WHERE quitado=true";
        List<Conta> contas = new ArrayList();
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                Categoria cat = new Categoria();
                c.setId(rs.getInt("contas.id"));
                c.setTitulo(rs.getString("contas.titulo"));
                c.setDescricao(rs.getString("contas.descricao"));

                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));
                c.setCategoria(cat);

                c.setTipo(ContaTipo.valueOf(rs.getString("contas.tipo")));
                c.setValor(rs.getLong("contas.valor"));
                c.setDtCriacao(rs.getDate("contas.dt_criacao").toLocalDate());
                c.setDtVencimento(rs.getDate("contas.dt_vencimento").toLocalDate());
                c.setQuitado(rs.getBoolean("contas.quitado"));

                contas.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contas;
    }

    public List<Conta> findPendentes() {
        String sql = "SELECT * FROM contas LEFT JOIN categorias "
                + "ON contas.cat_id=categorias.id WHERE quitado=false";
        List<Conta> contas = new ArrayList();
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                Categoria cat = new Categoria();
                c.setId(rs.getInt("contas.id"));
                c.setTitulo(rs.getString("contas.titulo"));
                c.setDescricao(rs.getString("contas.descricao"));

                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));
                c.setCategoria(cat);

                c.setTipo(ContaTipo.valueOf(rs.getString("contas.tipo")));
                c.setValor(rs.getLong("contas.valor"));
                c.setDtCriacao(rs.getDate("contas.dt_criacao").toLocalDate());
                c.setDtVencimento(rs.getDate("contas.dt_vencimento").toLocalDate());
                c.setQuitado(rs.getBoolean("contas.quitado"));

                contas.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contas;
    }

    public List<Conta> findVencidas() {
        String sql = "SELECT * FROM contas LEFT JOIN categorias "
                + "ON contas.cat_id=categorias.id WHERE dt_vencimento<curdate()";
        List<Conta> contas = new ArrayList();
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                Categoria cat = new Categoria();
                c.setId(rs.getInt("contas.id"));
                c.setTitulo(rs.getString("contas.titulo"));
                c.setDescricao(rs.getString("contas.descricao"));

                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));
                c.setCategoria(cat);

                c.setTipo(ContaTipo.valueOf(rs.getString("contas.tipo")));
                c.setValor(rs.getLong("contas.valor"));
                c.setDtCriacao(rs.getDate("contas.dt_criacao").toLocalDate());
                c.setDtVencimento(rs.getDate("contas.dt_vencimento").toLocalDate());
                c.setQuitado(rs.getBoolean("contas.quitado"));

                contas.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contas;
    }

    public List<Conta> findPendentesVencidas() {
        String sql = "SELECT * FROM contas LEFT JOIN categorias ON contas.cat_id=categorias.id "
                + "WHERE dt_vencimento<curdate() AND quitado=false";
        List<Conta> contas = new ArrayList();
        try (Connection con = fabrica.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                Categoria cat = new Categoria();
                c.setId(rs.getInt("contas.id"));
                c.setTitulo(rs.getString("contas.titulo"));
                c.setDescricao(rs.getString("contas.descricao"));

                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));
                c.setCategoria(cat);

                c.setTipo(ContaTipo.valueOf(rs.getString("contas.tipo")));
                c.setValor(rs.getLong("contas.valor"));
                c.setDtCriacao(rs.getDate("contas.dt_criacao").toLocalDate());
                c.setDtVencimento(rs.getDate("contas.dt_vencimento").toLocalDate());
                c.setQuitado(rs.getBoolean("contas.quitado"));

                contas.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contas;
    }
}
