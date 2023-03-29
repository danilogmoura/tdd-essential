package br.com.demo.camelcase;

public class CamelCaseConverter {
    public String convert(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }
}
