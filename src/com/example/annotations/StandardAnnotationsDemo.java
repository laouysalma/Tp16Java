package com.example.annotations;

import java.util.ArrayList;
import java.util.List;

public class StandardAnnotationsDemo {

	/**
	 * Méthode obsolète, à ne plus utiliser
	 */
	@Deprecated(since = "1.2", forRemoval = true)
	public void ancienneMethode() {
		System.out.println("Cette méthode est obsolète");
	}

	/**
	 * Remplace la méthode toString de la classe Object
	 */
	@Override
	public String toString() {
		return "StandardAnnotationsDemo";
	}

	/**
	 * Méthode avec avertissement supprimé
	 */
	@SuppressWarnings("unchecked")
	public List<String> getList() {
		// Génère normalement un avertissement "unchecked"
		ArrayList list = new ArrayList();
		return list;
	}

	public static void main(String[] args) {
		StandardAnnotationsDemo demo = new StandardAnnotationsDemo();

		// Utilisation d'une méthode dépréciée
		demo.ancienneMethode();

		// Affichage de la méthode toString surchargée
		System.out.println(demo);

		// Utilisation de la méthode avec avertissement supprimé
		List<String> liste = demo.getList();
		System.out.println("Liste créée: " + liste);
	}
}