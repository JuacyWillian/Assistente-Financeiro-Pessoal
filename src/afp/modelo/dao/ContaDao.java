package afp.modelo.dao;

import afp.modelo.Conta;
import java.util.List;

public class ContaDao implements IDAO<Conta> {

    private static final String INSERT = "INSERT INTO Conta VALUES (?,?,?,?,?,?,?,?,?)";

    public static ContaDao getInstance() {
        return new ContaDao();
    }

    @Override
    public boolean insert(Conta c) {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertMany(List<Conta> listObject) {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Conta obj) {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateMany(List<Conta> listObject) {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Conta obj) {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteMany(List<Conta> listObject) {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conta> findAll() {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta findOne(Conta obj) {
//        todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
