package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

    public static String fechaHoraActual() {
        LocalDateTime fechaHora = LocalDateTime.now();
        // return fechaHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        return fechaHora.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
