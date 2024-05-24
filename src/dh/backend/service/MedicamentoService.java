package dh.backend.service;

import dh.backend.DAO.IDAO;
import dh.backend.model.Medicamento;

import java.util.List;

public class MedicamentoService {
    private IDAO<Medicamento> medicamentoDao;

    public MedicamentoService(IDAO<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }


    public Medicamento registrarMedicamento(Medicamento medicamento) {
        return medicamentoDao.registrar(medicamento);
    }

    public Medicamento buscarPorCampo(String nombreCampo, String valorCampo) {
        return medicamentoDao.BuscarPorCampo(nombreCampo, valorCampo);
    }

    public Medicamento buscarPorId(Integer id) {
        return medicamentoDao.ConsultarByID(id);

    }

    public List<Medicamento> buscarTodos() {
        return medicamentoDao.ConsultarTodos();

    }

}
