package afp.modelo.dao;

import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.util.ContaTipo;
import afp.util.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ContaDAO implements IDAO<Conta> {

    private final FabricaDeConexoes fabrica;

    public ContaDAO() {
        fabrica = new FabricaDeConexoes();
    }

    @Override
    public void insert(Conta c) {
        throw new NotImplementedException();
    }

    @Override
    public Conta update(Conta c) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Conta c) {
        String sql = "DELETE from contas where contas.id=?";
        List<Conta> contaList = new ArrayList();
        try (Connection con = fabrica.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, c.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Conta> findAll() {
        String sql = "select * from contas LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        List<Conta> contaList = new ArrayList();
        try (Connection con = fabrica.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
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

    @Override
    public Conta findById(int id) {
        String sql = "select * from contas where contas.id=? LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        try (Connection con = fabrica.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
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
}
