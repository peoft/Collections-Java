import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExemploList {	

	public static void main(String[] args) {
		// Dada uma lista de 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
		
		// Formas de declarar!!!
		//List<Double> notas = new ArrayList<Double>();
		//List<Double> notas = new ArrayList<Double>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		// Não é possível alterar os elementos desta lista nesta forma
		//List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
		// Não é possível alterar os elementos desta lista nesta forma - Lista imutável.
		/*List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
		notas.add(1d);
		notas.remove(5d);
		System.out.println(notas);*/
		
		System.out.println("Crie uma lista e adicione as sete notas");
		List<Double> notas = new ArrayList<Double>();
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(0.0);
		notas.add(3.6);
		System.out.println("Forma 1=" + notas);
		System.out.println("Forma 2=" + notas.toString());
		
		System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5.0));
		System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
		notas.add(4, 8.0);
		System.out.println("Notas=" + notas.toString());
		System.out.println("Substitua a nota 5.0 pela nota 6.0:");
		notas.set(notas.indexOf(5.0), 6.0);
		System.out.println("Notas=" + notas.toString());
		System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5d));
		//System.out.println("Exiba todas as notas na ordem em que foram informadas:");
		//for (Double nota: notas) System.out.print(nota + " ");
		System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
		System.out.println(notas.toString());
		System.out.println("Exiba a menor nota: " + Collections.min(notas));
		System.out.println("Exiba a maior nota: " + Collections.max(notas));
		System.out.print("Exiba a soma dos valores: ");
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0d;
		while (iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		
		System.out.println(soma);
		
		System.out.println("Exiba a media das notas: " + soma/notas.size());
		System.out.println("Remova a nota 0: ");
		//notas.remove(notas.indexOf(0.0));
		notas.remove(0d);
		System.out.println(notas.toString());
		System.out.println("Remova a nota da posição 0");
		notas.remove(0);
		System.out.println(notas.toString());
		System.out.println("Remova as notas menores que 7 e exiba a lista: ");
		iterator = notas.iterator();
		while (iterator.hasNext()) {
			Double next = iterator.next();
			if (next < 7) {
				iterator.remove();
			}				
		}
		System.out.println(notas);
		//System.out.println("Apague toda a lista: ");
		//notas.clear();
		//System.out.println(notas);
		System.out.println("Confira se a lista está vazia: " + notas.isEmpty());
		
		LinkedList notas2 = new LinkedList();
		notas2.addAll(notas);
		System.out.println("Lista 2: " + notas2);
		System.out.println("Primeira nota da lista: " + notas2.getFirst());
		System.out.println("Lista 2: " + notas2);
		System.out.println("Primeiro elemento removido: " + notas2.poll());
		System.out.println("Lista 2: " + notas2);
		
		
	}

}
