package com.ziooo.jontosite.enumeration;

public enum ErrorMessage {
    ERROR_JSON_IS_EMPTY("Aucun fichier JSON en paramètre"), WARN_DB_IS_EMPTY(
	    "Aucune base de donnée en paramètre"), FILE_NOT_FOUND("Le fichier n'existe pas");
    
    private final String name;

    private ErrorMessage(String s) {
	name = s;
    }

    public boolean equalsName(String otherName) {
	return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
	return name;
    }
}
