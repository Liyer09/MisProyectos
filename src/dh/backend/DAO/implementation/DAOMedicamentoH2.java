package dh.backend.DAO.implementation;

import dh.backend.DAO.IDAO;
import dh.backend.db.H2Connection;
import dh.backend.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class DAOMedicamentoH2 implements IDAO<Medicamento> {

    public static Logger LOGGER = Logger.getLogger(DAOMedicamentoH2.class);

    public Connection conn =  null;
    @Override
    public Medicamento registrar(Medicamento objeto) {
        try {
            this.conn = H2Connection.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO MEDICAMENTOS VALUES (DEFAULT, ?, ?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objeto.getCodigo());
            preparedStatement.setString(2, objeto.getNombre());
            preparedStatement.setString(3, objeto.getLaboratorio());
            preparedStatement.setInt(4, objeto.getCantidad());
            preparedStatement.setDouble(5, objeto.getPrecio());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                objeto.setId(id);
            }
            LOGGER.info("Medicamento persistido: "+ objeto);
            conn.commit();
            conn.setAutoCommit(true);
        }catch (Exception ex){
            LOGGER.error("Ocurrio un error registrando el medicamento " + ex.getMessage());
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
            objeto = null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }

        return objeto;
     }

    @Override
    public List<Medicamento> ConsultarTodos() {
        return null;
    }

    @Override
    public Medicamento ConsultarByID(Integer id) {
        return null;
    }

    @Override
    public Medicamento BuscarPorCampo(String nombreCampo, String valorCampo) {
        return null;
    }
}
