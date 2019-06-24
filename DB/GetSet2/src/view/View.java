package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;


import controller.Controller;
import controller.ControllerOrders;
import model.Model;
import model.ModelU;

public class View extends Controller{
	Scanner input = new Scanner(System.in);

	Controller c = new Controller();

	ControllerOrders cO = new ControllerOrders();

	CopyOnWriteArrayList<Model> listaUtenti = new CopyOnWriteArrayList<Model>();

	CopyOnWriteArrayList<ModelU> listaOrdini = new CopyOnWriteArrayList<ModelU>();

	public void scelta() throws IOException {
		int scelta;

		boolean light = true;

		int sceltaMenù;

		boolean flags = true;

		while(flags) {

			System.out.println("Scegli 0 - Menù Principale, 1 - Menù JOIN");

			sceltaMenù = Integer.parseInt(input.nextLine());

			if(sceltaMenù == 0) {

				while(light) {
					try {
						System.out.println("0 - Inserisci 1 - Leggi 2 - Leggi Singolo 3 - Eliminare 4 - Aggiorna 5 - Leggi Cestino, 100 - Uscita");

						System.out.println("Scelta");
						String scelta2;
						scelta = Integer.parseInt(input.nextLine());
						switch(scelta) {
						case 0: System.out.println("Inserimento cliente o prodotto");
						scelta2 = input.nextLine().toLowerCase();
						if(scelta2.contentEquals("cliente")) {
							System.out.println(c.creazione(list));
							c.pulisciLista();
						}else if(scelta2.contentEquals("prodotto")){
							cO.inserimentoOrdine(listOrders);
							cO.pulisciOrdini();
						}
						break;
						case 1: System.out.println("Leggi cliente o prodotto");
						scelta2 = input.nextLine().toLowerCase();
						if(scelta2.contentEquals("cliente")) {
							c.eseguiTutto();
						}else if(scelta2.contentEquals("prodotto")){
							cO.leggiListaOrdini();
						}
						break;
						case 2: System.out.println("Leggi singolo cliente o prodotto");
						scelta2 = input.nextLine().toLowerCase();
						if(scelta2.contentEquals("cliente")) {
							c.eseguiSingolo();
						}else if(scelta2.contentEquals("prodotto")){
							cO.leggiSingoloProdotto();
						}
						break;
						case 3: System.out.println("Elimina cliente o prodotto");
						scelta2 = input.nextLine().toLowerCase();
						if(scelta2.contentEquals("cliente")) {
							c.elimina();
						}else if(scelta2.contentEquals("prodotto")){
							cO.eliminaOrdine();
						}
						break;
						case 4 : System.out.println("Aggiorna cliente o prodotto");
						scelta2 = input.nextLine().toLowerCase();
						if(scelta2.contentEquals("cliente")) {
							c.aggiorna();
						}else if(scelta2.contentEquals("prodotto")){
							cO.aggiornamentoOrdine();
						}
						break;
						case 5: System.out.println("Leggi cestino cliente o prodotto");
						scelta2 = input.nextLine().toLowerCase();
						if(scelta2.contentEquals("cliente")) {
							c.leggiCestino();
						}else if(scelta2.contentEquals("prodotto")){
							cO.leggiCestinoOrdini();
						}
						break;
						case 100: System.out.println("Uscita");
						light = false;
						break;
						default: System.out.println("Errore");
						break;
						}
					}catch(Exception e) {
						e.getMessage();
						System.out.println("Lettera o simbolo sbagliato");
					}
				}
			}else if (sceltaMenù == 1) {

				int s;

				System.out.println("Scelta 0 - JOIN, 1 - Inserimento utente e ordine. 2 - Uscita");

				s = Integer.parseInt(input.nextLine());

				if(s == 0){

					if(listaUtenti.size() > 0 && listaOrdini.size() > 0) {

						for(Model l :listaUtenti) {
							for(ModelU lO : listaOrdini) {
								System.out.println(l.getName() + " " + l.getNumero() + " " + lO.getCodice() + " "+ lO.getPrezzo());
							}
						}
						
					}else {
						System.out.println("Non ci sono utenti e ordini a disposizione per creare una join");
					}
					
				}else if(s == 1) {

					listaUtenti = c.creazione(listaUtenti);

					listaOrdini = cO.inserimentoOrdine(listaOrdini);

				}else if (s == 2){
					System.out.println("Uscita");
					flags = false;
				}
			}
		}
	}
}
