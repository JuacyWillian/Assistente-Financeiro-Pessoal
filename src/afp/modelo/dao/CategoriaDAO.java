/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afp.modelo.dao;

import afp.modelo.Categoria;
import afp.util.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author jw
 */
public class CategoriaDAO implements IDAO<Categoria> {

    private final FabricaDeConexoes fabrica;

    public CategoriaDAO() {
        fabrica = new FabricaDeConexoes();
    }

    @Override
    public void insert(Categoria c) {
        throw new NotImplementedException();
    }

    @Override
    public Categoria update(Categoria c) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Categoria c) {
        throw new NotImplementedException();
    }

    @Override
    public List<Categoria> findAll() {
        String sql = "select * from contas LEFT JOIN categorias ON contas.cat_id = categorias.id;";
        List<Categoria> contaList = new ArrayList();
        try (Connection con = fabrica.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return contaList;
    }

    @Override
    public Categoria findById(int id) {
        throw new NotImplementedException();
    }
}
