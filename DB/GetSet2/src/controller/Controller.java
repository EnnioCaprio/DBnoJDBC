package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import model.Model;
import model.ModelU;

public class Controller extends ControllerOrders implements InterfacciaModel{

	ControllerOrders cO = new ControllerOrders();

	Scanner input = new Scanner(System.in);

	public CopyOnWriteArrayList<Model> list = new CopyOnWriteArrayList<Model>();

	CopyOnWriteArrayList<Model> li = new CopyOnWriteArrayList<Model>();

	Set<Model> cestino = new HashSet<Model>();
	
	//CopyOnWrite

	@Override
	public CopyOnWriteArrayList<Model> creazione(CopyOnWriteArrayList<Model> list) {
		
		this.list = list;

		int ripetizioni;

		System.out.println("Inserire il numero di utenti da inserire");

		ripetizioni = Integer.parseInt(input.nextLine());

		for(int i = 0; i < ripetizioni ; i++) {
			if(list.size() == 0) {
				Model m = new Model();
				System.out.println("Id");
				m.setId(Integer.parseInt(input.nextLine()));
				System.out.println("Nome");
				m.setName(input.nextLine());
				System.out.println("Numero");
				m.setNumero(input.nextLine());

				list.add(m);

			}else if(list.size() > 0) {
				Model m = new Model();
				System.out.println("Id");
				m.setId(Integer.parseInt(input.nextLine()));
				System.out.println("Nome");
				m.setName(input.nextLine());
				System.out.println("Numero");
				m.setNumero(input.nextLine());
				for(Model l : list) {
					if(l.getId() != m.getId()) {
						list.add(m);
					}else {
						System.out.println("Errore, c'è un duplicato");
						cestino.add(m);
					}
				}

			}

		}
		/*for(Model l : list) {
			System.out.println(l);
		}*/
		
		return list;
	}
	
	@Override
	public void pulisciLista() {

		for (Model m : list) {
			for (Model m1 : cestino) {
				if((m.getId() == m1.getId()) && (m.getName().equals(m1.getName()) && (m.getNumero().equals(m1.getNumero())))) {
					list.remove(m);
				}
			}
		}
	}

	@Override
	public void eseguiTutto() {

		if(list.size() > 0) {
			for (Model l : list) {
				System.out.println(l);
			}
		}else {
			System.out.println("Errore, non ci sono utenti nel database");
		}
	}

	@Override
	public void eseguiSingolo() {

		int uguaglianza;

		if(list.size() > 0) {

			System.out.println("Scegli numero utente");

			uguaglianza = input.nextInt();

			for(Model l : list) {
				if(l.getId() == uguaglianza) {
					System.out.println(l.getName() + " " + l.getNumero());
				}
			}
		}else {
			System.out.println("Error, non ci sono persone nel database");
		}
	}
	@Override
	public void elimina() {

		if(list.size() > 0) {

			int scelta;

			scelta = Integer.parseInt(input.nextLine());

			/*for (Iterator<Model> iterator = list.iterator(); iterator.hasNext();) {
				Model s =  iterator.next();
				if (s.getId() == scelta) {
					iterator.remove();
				}else {
					System.out.println("Utente non esistente");
				}
			}*/

			for(Model l : list) {
				if(l.getId() == scelta) {
					list.remove(l);
				}else {
					System.out.println("Utente non esistente");
				}
			}

		}else {
			System.out.println("Non esistono utenti nel nostro database");
		}

	}
	@Override
	public void aggiorna() {

		if(list.size() > 0) {

			int scelta;

			scelta = Integer.parseInt(input.nextLine());

			/*for (Iterator<Model> iterator = list.iterator(); iterator.hasNext();) {
				Model s =  iterator.next();
				if (s.getId() == scelta) {
					iterator.remove();
					Model m = new Model();
					m.setId(scelta);
					m.setName(input.nextLine());
					m.setNumero(input.nextLine());
					list.add(m);
				}else {
					System.out.println("Utente non esistente nel corrente database");
				}
			}*/
			for(Model l : list) {
				if(l.getId() == scelta) {
					list.remove(l);
					Model m = new Model();
					m.setId(scelta);
					m.setName(input.nextLine());
					m.setNumero(input.nextLine());
					list.add(m);
				}else {
					System.out.println("Utente non esistente");
				}
			}
		}else {
			System.out.println("Non esistono utenti nel nostro database");
		}

	}
	@Override
	public void leggiCestino() {
		for(Model co : cestino) {
			System.out.println(co);
		}
	}

	public void commonElements() {

	}

}
