package com.matheusrabelo.mr.resources.utill;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	public static String decodeParam(String s) {
		try {
			URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {

			return "";
		}
		return s;
	}

	public static List<Integer> decodeIntList(String s) {
		String[] vetor = s.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < vetor.length; i++) {
			list.add(Integer.parseInt(vetor[i]));
		}
		return list;

		// return Arrays.asList(s.split(",")).stream().map(x ->
		// Integer.parseInt(x)).collect(Collectors.toList());

	}

}
