package api;

import java.util.List;

import modelo.Mesa;
import modelo.ProductoInventario;

public interface ServiceMesa {
	 String registrarProducto(Mesa mesa);
	 Mesa getMesa(int claveMesa);
	 List<Mesa> getMesas();
	 int eliminarMesa(int claveMesa);
	 String modificarMesa(Mesa mesa);
}
