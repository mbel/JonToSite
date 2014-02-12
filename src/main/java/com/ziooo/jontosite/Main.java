package com.ziooo.jontosite;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziooo.jontosite.enumeration.ErrorMessage;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger("Main");

    public static void main(String[] args) {
	File file = null;
	if (args[0] == null) {
	    logger.error(ErrorMessage.ERROR_JSON_IS_EMPTY.toString());
	} else {
	    file = new File(args[0]);
	    if (file.isFile()) {
		logger.info("Traitement démarré pour le fichier "
			+ file.getName());
	    } else {
		logger.error(ErrorMessage.FILE_NOT_FOUND.toString());
		return;
	    }
	}
	if (args[1] == null) {
	    logger.warn(ErrorMessage.WARN_DB_IS_EMPTY.toString());
	}

	JsonFactory jfactory = new JsonFactory();

	/*** read from file ***/
	JsonParser jParser;
	try {
	    jParser = jfactory.createJsonParser(file);
	    String firstFieldname = null;
	    while (jParser.nextToken() != JsonToken.END_OBJECT) {
		String fieldname = jParser.getCurrentName();

		if (firstFieldname == null) {
		    firstFieldname = fieldname;
		} else {
		    if (firstFieldname.equals(fieldname)) {
			return;
		    }
		}
		logger.info(fieldname);
		jParser.nextToken();
		logger.info(jParser.getText());
	    }
	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
