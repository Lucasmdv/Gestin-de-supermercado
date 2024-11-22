package Clases;

import org.json.JSONException;
import org.json.JSONObject;

public class Empleado extends Persona{

    //Atributos: id, nombre(super), cargo, salario

    private static int id;
    private String cargo;
    private double salario;

    ///Constructores

    public Empleado(){}
    public Empleado(String dni, String nombre, String apellido, String cargo, double salario) {
        super(dni, nombre, apellido);
        this.cargo = cargo;
        this.salario = salario;
        id++;
    }

    public Empleado(JSONObject jsonEmpleado) {
        super(jsonEmpleado);
        try {
            this.id = jsonEmpleado.getInt("id");
            this.cargo = jsonEmpleado.getString("cargo");
            this.salario = jsonEmpleado.getDouble("salario");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }

    public double calcularSalario() { //MODIFICARSE SEGUN EMPLEADO
        return salario;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON(); // Llamar al método toJSON de la clase padre
        try {
            jsonObject.put("id", id);
            jsonObject.put("cargo", cargo);
            jsonObject.put("salario", salario);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
