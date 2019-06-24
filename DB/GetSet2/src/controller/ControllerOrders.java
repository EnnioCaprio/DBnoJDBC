package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import model.ModelU;


public class ControllerOrders implements InterfacciaModelOrdini{

	Scanner input = new Scanner(System.in);

	public static CopyOnWriteArrayList<ModelU> listOrders = new CopyOnWriteArrayList<ModelU>();
	
	int b = 100;
	
	List<ModelU> lA = new ArrayList<ModelU>();
	
	ModelU u = new ModelU();

	CopyOnWriteArrayList<ModelU> listCestino = new CopyOnWriteArrayList<ModelU>();
	
	CopyOnWriteArrayList<ModelU> piglialo = new CopyOnWriteArrayList<ModelU>();
	@Override
	public CopyOnWriteArrayList<ModelU> inserimentoOrdine(CopyOnWriteArrayList<ModelU> listOrders) {
		int ripetizioni;

		System.out.println("Quanti prodotti vuoi inserire");

		ripetizioni = Integer.parseInt(input.nextLine());

		for(int i = 0; i < ripetizioni; i++) {
			if(listOrders.size() == 0) {
				ModelU m = new ModelU();
				System.out.println("Inserisci l'id prodotto");
				m.setId(Integer.parseInt(input.nextLine()));
				System.out.println("Inserisci il codice prodotto");
				m.setCodice(Integer.parseInt(input.nextLine()));
				System.out.println("Inserisci il nome prodotto");
				m.setName(input.nextLine());
				System.out.println("Inserisci prezzo");
				m.setPrezzo(Double.parseDouble(input.nextLine()));
				listOrders.add(m);
			}else if(listOrders.size() > 0) {
				ModelU mU = new ModelU();
				System.out.println("Inserisci l'id prodotto");
				mU.setId(Integer.parseInt(input.nextLine()));
				System.out.println("Inserisci il codice prodotto");
				mU.setCodice(Integer.parseInt(input.nextLine()));
				System.out.println("Inserisci il nome prodotto");
				mU.setName(input.nextLine());
				System.out.println("Inserisci prezzo");
				mU.setPrezzo(Double.parseDouble(input.nextLine()));
				for(Iterator<ModelU> it = listOrders.iterator(); it.hasNext();) {
					ModelU mUi = it.next();   
					if(mUi.getId() != mU.getId()) {
						System.out.println("------");
						listOrders.add(mU);
					}else {
						System.out.println("C'è già un prodotto con lo stesso codice rappresentativo");
						listCestino.add(mU);
					}
				}
			}
		}
		return listOrders;
	}	
	
	
	@Override
	public void leggiListaOrdini() {
		for(ModelU l : listOrders) {
			System.out.println(l);
		}
	}
	
	public CopyOnWriteArrayList<ModelU> getList(){
		for(ModelU l : listOrders) {
			System.out.println(l);
		}
		return getList();
		
	}
	
	@Override
	public void leggiCestinoOrdini() {
		for(ModelU lC : listCestino) {
			System.out.println(lC);
		}
	}

	@Override
	public void pulisciOrdini() {
		for(ModelU lU : listOrders) {
			for(ModelU lC : listCestino) {
				if((lU.getId() == lC.getId()) && (lU.getCodice() == lC.getCodice()) && (lU.getName().equals(lC.getName()) && (lU.getPrezzo() == lC.getPrezzo()))) {
					listOrders.remove(lU);
				}
			}
		}
	}

	@Override
	public void leggiSingoloProdotto() {

		int codice;

		codice = Integer.parseInt(input.nextLine());

		for(ModelU l : listOrders) {
			if(l.getCodice() == codice) {
				System.out.println(l.getCodice() + " " + l.getName());
			}
		}
	}

	@Override
	public void eliminaOrdine() {

		int codice;

		codice = Integer.parseInt(input.nextLine());

		for(Iterator<ModelU> it = listOrders.iterator(); it.hasNext();) {
			ModelU s = it.next();	
			if(s.getId() == codice) {
				listOrders.remove(s);
			}
		}

	}
	
	@Override
	public void aggiornamentoOrdine() {
		int codice;
		
		codice = Integer.parseInt(input.nextLine());
		
		for(Iterator<ModelU> it = listOrders.iterator(); it.hasNext();) {
			ModelU s = it.next();
			if(s.getId() == codice) {
				listOrders.remove(s);
				ModelU m = new ModelU();
				m.setId(codice);
				System.out.println("Inserisci il codice prodotto");
				m.setCodice(Integer.parseInt(input.nextLine()));
				System.out.println("Inserisci nome prodotto");
				m.setName(input.nextLine());
				listOrders.add(m);
			}
		}
	}
}
