package com.juanpabloprado.goalrangesandbonuses.fc;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.juanpabloprado.goalrangesandbonuses.salary.Level;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nombre",
        "nivel",
        "goles",
        "sueldo",
        "bono",
        "sueldo_completo",
        "equipo"
})
public class Player {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("nivel")
    private Level nivel;
    @JsonProperty("goles")
    private int goles;
    @JsonProperty("sueldo")
    private int sueldo;
    @JsonProperty("bono")
    private int bono;
    @JsonProperty("sueldo_completo")
    private Integer sueldoCompleto;
    @JsonProperty("equipo")
    private Player.Equipo equipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel.toString();
    }

    public void setNivel(String nivel) {
        this.nivel = Level.valueOf(nivel.toUpperCase());
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getBono() {
        return bono;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }

    public Integer getSueldoCompleto() {
        return sueldoCompleto;
    }


    public void setSueldoCompleto(Integer sueldoCompleto) {
        this.sueldoCompleto = sueldoCompleto;
    }

    public Player.Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Player.Equipo equipo) {
        this.equipo = equipo;
    }

    public enum Equipo {

        ROJO("rojo"),
        AZUL("azul");
        private final String value;
        private final static Map<String, Player.Equipo> CONSTANTS = new HashMap<>();

        static {
            for (Player.Equipo c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Equipo(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Player.Equipo fromValue(String value) {
            Player.Equipo constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Override
    public String toString() {
        return "Player{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", goles=" + goles +
                ", sueldo=" + sueldo +
                ", bono=" + bono +
                ", sueldoCompleto=" + sueldoCompleto +
                ", equipo=" + equipo +
                '}';
    }
}