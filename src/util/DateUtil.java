package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    public static String fechaActual() {
        // Java API Time
        LocalDate fecha = LocalDate.now();
        //return fecha.toString();
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String horaActual() {
        LocalTime hora = LocalTime.now();
        return hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
