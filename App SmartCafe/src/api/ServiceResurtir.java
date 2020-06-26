package api;

import java.util.List;

import modelo.Resurtir;

public interface ServiceResurtir {
	String registrarResurtir(Resurtir resurtir);
	Resurtir getResurtir(int numResurtir);
	List<Resurtir> getResurtidos();
	int eliminarResurtir(int numResurtir);
	String modificarResurtir(Resurtir resurtir);
}
