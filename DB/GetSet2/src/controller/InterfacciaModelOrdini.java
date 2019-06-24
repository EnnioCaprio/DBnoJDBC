package controller;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import model.Model;
import model.ModelU;

public interface InterfacciaModelOrdini {
	public void leggiListaOrdini();
	public void leggiCestinoOrdini();
	//public void inserimentoOrdine();
	public void pulisciOrdini();
	public void leggiSingoloProdotto();
	public void eliminaOrdine();
	public void aggiornamentoOrdine();
	CopyOnWriteArrayList<ModelU> inserimentoOrdine(CopyOnWriteArrayList<ModelU> listOrders);
}
