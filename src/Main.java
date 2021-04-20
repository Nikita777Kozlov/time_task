import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;


class Main {


    public static void main(String[] args) throws ParseException {
        List<String> arrStart = new ArrayList<>();
        List<String> arrEnd = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество периодов: ");
        int n = scanner.nextInt();
        while (n != 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите  период: ");
            String a = scan.nextLine();

            String[] t = a.split("-");

            DateTimeFormatter formatter12 = DateTimeFormatter.ofPattern("hh:mm a"); //format 12 hours
            DateTimeFormatter formatter24 = DateTimeFormatter.ofPattern("HH:mm");
            arrStart.add(formatter24.format(formatter12.parse(t[0])));
            arrEnd.add(formatter24.format(formatter12.parse(t[1])));

            n = n - 1;
        }
        Collections.sort(arrStart);
        Collections.sort(arrEnd);


        List<String> arrResults = new ArrayList<>();

        for (int i = 0; i < arrStart.size() - 1; i++) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");

            Date dateS = format.parse(arrStart.get(i + 1));
            Date dateE = format.parse(arrEnd.get(i));

            long delt = dateS.getTime() - dateE.getTime();

            String result = String.format("%dч %dмин",
                    (delt % 86400000) / 3600000,
                    (delt % 3600000) / 60000);

            arrResults.add(result);
// magic. time spend on code optimisation = 324
// please increase counter to avoid
              /*  Duration duration = Duration.between(start, end);
                DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
                LocalDateTime  a = LocalDateTime.parse(arrStart.get(i+1),df);
                LocalDateTime  b = LocalDateTime.parse(arrEnd.get(j),df);
                Duration duration = Duration.between(a,b);
                System.out.println(duration);  */
        }

        Collections.sort(arrResults);
        System.out.println(arrResults.get(arrResults.size() - 1));


        System.out.println(arrStart);
        System.out.println(arrEnd);

    }
}


