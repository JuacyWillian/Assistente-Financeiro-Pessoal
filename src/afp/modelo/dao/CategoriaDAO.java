package afp.modelo.dao;

import afp.modelo.Categoria;
import afp.util.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements IDAO<Categoria> {

    private final FabricaDeConexoes fabrica;

    public CategoriaDAO() {
        fabrica = new FabricaDeConexoes();
    }

    @Override
    public void insert(Categoria c) {
        String sql = "INSERT INTO contas(titulo, descricao) VALUES(?,?)";
        try (Connection con = fabrica.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getDescricao());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Categoria c) {
        String sql = "UPDATE categorias SET (titulo=?, descricao=?) "
                + "WHERE categorias.id=?;";
        try (Connection con = fabrica.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getDescricao());
            ps.setInt(3, c.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Categoria c) {
        String sql = "DELETE from categorias where categorias.id=?";
        try (Connection con = fabrica.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, c.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Categoria> findAll() {
        String sql = "select * from contas "
                + "LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        List<Categoria> categoriaList = new ArrayList();
        try (Connection con = fabrica.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Categoria cat = new Categoria();
                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));

                categoriaList.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categoriaList;
    }

    @Override
    public Categoria findById(int id) {
        String sql = "select * from contas where contas.id=? "
                + "LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        try (Connection con = fabrica.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("categorias.id"));
                cat.setTitulo(rs.getString("categorias.titulo"));
                cat.setDescricao(rs.getString("categorias.descricao"));
                return cat;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
