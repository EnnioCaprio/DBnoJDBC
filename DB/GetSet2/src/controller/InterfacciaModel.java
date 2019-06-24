package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

import model.Model;

public interface InterfacciaModel {
	//public void creazione();
	public void eseguiTutto();
	public void eseguiSingolo();
	public void elimina();
	public void aggiorna();
	public void leggiCestino();
	public void pulisciLista();
	CopyOnWriteArrayList<Model> creazione(CopyOnWriteArrayList<Model> list);
}
