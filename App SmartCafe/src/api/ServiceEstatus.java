package api;

import java.util.List;

import modelo.Estatus;
import modelo.ProductoInventario;

public interface ServiceEstatus {
	 String registrarEstatus(Estatus estatus);
	 Estatus getEstatus(int numStatus);
	 List<Estatus> getEstatus1();
	 int eliminarEstatus(int numStatus);
	 String modificarEstatus(Estatus estatus);
}
