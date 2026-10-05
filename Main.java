package vehiculo;


public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo();
        Vehiculo v2 = new Vehiculo("A123456");
        Vehiculo v3 = new Vehiculo("B987654", "Toyota", "Corolla");

        System.out.println(v1 + "\n" + v2 + "\n" + v3);

        System.out.printf("Solo km:                $%.2f%n", v3.calcularMantenimiento(15000));
        System.out.printf("km + correctivo:        $%.2f%n", v3.calcularMantenimiento(15000, "correctivo"));
        System.out.printf("completo + repuestos:   $%.2f%n", v3.calcularMantenimiento(15000, "completo", true));
    }
}
