import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExerciciosPropostos {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Executando exercicio 1...");
		Exercicio1.execute(input);
		System.out.println("\nExecutando exercicio 2...");
		Exercicio2.execute(input);
		input.close();
	}
}

class Exercicio1 {
	public static void execute(Scanner input) {
		
		int count = 0;
		Double average;
		List<MonthAverage> averages = new ArrayList<>();
		
		System.out.println("Digite a temperatura media para os 6 primeiros meses do ano:");
		do {
			average = input.nextDouble();
			count++;
			averages.add(new MonthAverage(count, MonthAverage.getMonthByIndex(count), average));
		} while (count < 6);
		System.out.println("Lista: ");
		System.out.println(averages);
		System.out.print("Media semestral das temperaturas: ");
		Iterator<MonthAverage> iterator = averages.iterator();
		Double semesterAverage = 0d;
		while (iterator.hasNext()) {
			MonthAverage next = iterator.next();
			semesterAverage += next.getAverage();
		}
		semesterAverage /= 6;
		System.out.println(semesterAverage);
		System.out.println("Temperaturas acima da média: ");
		iterator = averages.iterator();
		while (iterator.hasNext()) {
			MonthAverage next = iterator.next();
			Double value = next.getAverage();
			if (value > semesterAverage) {
				System.out.println(value + " no mes de " + MonthAverage.getMonthByIndex(next.getIndex()));
			}
		}
	}
}

class Exercicio2 {
	public static void execute(Scanner input) {
		//Scanner input2 = new Scanner(System.in);
		String answer;
		List<Questions> questions = new ArrayList<>() {{
			add(new Questions(false, "Telefonou para a vitima?"));
			add(new Questions(false, "Esteve no local do crime?"));
			add(new Questions(false, "Mora perto da vitima?"));
			add(new Questions(false, "Devia para a vitima?"));
			add(new Questions(false, "Já trabalhou com a vitima?"));
		}};
		
		
		Iterator<Questions> iterator = questions.iterator();
		while (iterator.hasNext()) {
			Questions next = iterator.next();
			System.out.print(next.getQuestion());			
			answer = input.next();
			if (answer.equalsIgnoreCase("s")) {
				next.setAnswer(true);
			}
		}
		
		System.out.println("Respostas: ");
		System.out.println(questions);
		
		System.out.println("Pessoa e " + Questions.getResult(questions));
	}
}

class MonthAverage {
	private int index;
	private String month;
	private Double average;
	
	public MonthAverage(int index, String month, Double average) {
		this.index = index;
		this.month = month;
		this.average = average;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}

	public Double getAverage() {
		return average;
	}
	
	public void setAverage(Double average) {
		this.average = average;
	}
	
	public static String getMonthByIndex(int index) {
		String month;
		
		switch(index) {
		case 1:
			month = "Janeiro";
			break;
		case 2:
			month = "Fevereiro";
			break;
		case 3:
			month = "Março";
			break;
		case 4:
			month = "Abril";
			break;
		case 5:
			month = "Maio";
			break;
		case 6:
			month = "Junho";
			break;
		default:
			month = "Invalido";
		}
		return month;
	}

	@Override
	public String toString() {
		return "{index=" + index + ", month=" + month + ", average=" + average + "}";
	}	
}

class Questions {
	boolean answer;
	String question;

	public Questions(boolean answer, String question) {
		super();
		this.answer = answer;
		this.question = question;
	}
	
	public static String getResult(List<Questions> questions) {
		Iterator<Questions> iterator = questions.iterator();
		int count = 0;
		String result;
		while (iterator.hasNext()) {
			Questions next = iterator.next();
			if (next.getAnswer() == true) {
				count++;
			}
		}
		if (count == 2) {
			result = "Suspeita";
		} else if (count > 2 && count <= 4) {
			result = "Cumplice";
		} else if (count == 5) {
			result = "Assassina";
		} else {
			result = "Inocente";
		}
		return result;
	}

	public String getQuestion() {
		return question;
	}

	@Override
	public String toString() {
		return "{answer=" + answer + ", question=" + question + "}";
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Questions(boolean answer) {
		super();
		this.answer = answer;
	}

	public boolean getAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	
}