package org.example;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.example.model.TreeNodeImpl;
import org.fit.pdfdom.PDFDomTree;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.tree.TreeNode;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

//        readJsonFile();

//        readPdfDnrpa();
//            readLine();


//        generateHTMLFromPDF();

//        parseJsonResponses();

//        String payload = restPut("https://www.mercadolibre.com.ar/publicar/vehiculos/api/flux/connection?sessionId=33533529-listmot-8da46425b212&step=step_one&vertical=vehiculos","{\"listmot-0.temp.category_selector\": {\"catalog_attributes\": [{\"name\": \"Marca\",\"id\": \"BRAND\",\"value_id\": \"60279\",\"value_name\": \"Peugeot\"},{\"name\": \"Modelo\",\"id\": \"MODEL\",\"value_id\": \"36046\",\"value_name\": \"307\"}],\"item_category_id\": \"MLA1744\"},\"temp.confirmed_task_id\": \"category_task\",\"navigation\": [\"step_one\"],\"listmot-0.brick_navigation.step_one\": [\"page_breadcrumb\",\"msg_redirect_to_products\",\"header_page\",\"title_task\",\"category_task\"],\"nextStep\": \"step_one\"}");
//
//        JSONArray response = formatMeliPutResponse(payload);



//        readCSV("c:\\testfiles\\Tabla valuación autos.csv");

//        parseJsonResponsesYearModelType();

//        parseJsonResponsesCustomModels();

        System.out.println("\n\nFibonacci ++++++++++++++++");

        fibonacci(10);

        System.out.println("\n\nFibonacci recursivo ++++++++++++++++");

        int N = 10;

        // Print the first N numbers
        for (int i = 0; i < N; i++) {

            System.out.print(fibonacciRecurisive(i) + " ");
        }

        System.out.println("\n\nBinary trees ++++++++++++++++");

        int[] preorder = {1, 2, 4, 5, 3 };
        int[] inorder = {4, 2, 5, 1, 3};

        System.out.println(preorder.length);

        System.out.println("\n\nSort ++++++++++++++++");

        int[] array = {7, 1, 3, 2, 4, 5, 6 };

        System.out.println("Minimum swaps " + minimumSwaps(array));

        System.out.println("\n\nString manipulation ++++++++++++++++");

        String one = "fcrxzwscanmligyxyvym";
        String two = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        System.out.println("Deletions: " + deletionForAnagrams2(one,two));



        final String path = "prueba/archivo/archivo2";
        final String[] pathTokens = path.split("/");

        System.out.println(pathTokens.length);
    }

    static int deletionForAnagrams(String a, String b) {
        int deletions = 0;

        boolean match = false;
        int iterations = 0;


        for(int i=0;i<a.length();){
            iterations++;

            for(int j=0;j<b.length();){
                if(b.contains(String.valueOf(a.charAt(i)))) {
                    if (b.startsWith(String.valueOf(a.charAt(i)))) {
                        b = b.substring(j + 1);
                        match = true;

                        System.out.println("Iterations: " + iterations + " MATCH ");

                        break;
                    }else{
                        deletions ++;
                        b = b.substring(j + 1);

                        j=0;
                    }
                }else{
                    break;
                }
            }

            if(!match){
                deletions ++;
            }

            a = a.substring(i+1);
            i=0;
            match = false;

            System.out.println("Iterations: " + iterations + " One: " + a + " Two: " + b + " deletions: " + deletions);

        }

        return deletions;
    }

    static int deletionForAnagrams2(String a, String b) {
        String aux;

        aux = a;
        for(int i=0;i<a.length();){
           if(b.contains(String.valueOf(a.charAt(i)))){
               aux = aux.replaceFirst(String.valueOf(a.charAt(i)),"");
               b = b.replaceFirst(String.valueOf(a.charAt(i)),"");
           }else{
               i++;
           }

            System.out.println(" One: " + aux + " Two: " + b);

        }

        return aux.length()+b.length();
    }

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int currentVal;

        int i=0;
        while(i<arr.length){
            currentVal = arr[i];

            if(currentVal == i+1){
                i++;
            }else{
                arr[i] = arr[currentVal-1];
                arr[currentVal-1] = currentVal;

                swaps ++;
            }


//            printArray(arr);
        }

        return swaps;

    }

    static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
        System.out.println("");
    }

    /***
     * FIBONACCI COMUN
     * @param N
     */
    static void fibonacci(int N)
    {
        int num1 = 0, num2 = 1;

        int counter = 0;

        // Iterate till counter is N
        while (counter < N) {

            // Print the number
            System.out.print(num1 + " ");

            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
    }

    /***
     * FIBONACCI RECURSIVO
     * @param n
     * @return
     */
    static int fibonacciRecurisive(int n)
    {
        // Base Case
        if (n <= 1)
            return n;

        // Recursive call
        return fibonacciRecurisive(n - 1)
                + fibonacciRecurisive(n - 2);
    }

    /**
     * Binary search
     */

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while (left<= right){
            int mid = (left + right ) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid+1;
            else{
                right = mid -1;
            }
        }
        return -1;
    }

    /**
     * Mirror of a tree
     *
     * IS RECURSIVE. cAN'T BE USED WITH A VERY BIG TREE
     */
    public TreeNodeImpl invertTree(TreeNodeImpl root) {
        if (root == null){
            return null;
        }

        TreeNodeImpl left = invertTree(root.left);
        TreeNodeImpl right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * tree is simetric
     */

    public boolean isSymmetric(TreeNodeImpl root) {
        if (root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNodeImpl n1, TreeNodeImpl n2){
        if(n1 == null && n2 == null)
            return true;
        if(n1 == null || n2 == null)
            return false;
        if(n1.val != n2.val)
            return false;
        return isMirror(n1.left, n2.right) && isMirror(n1.right,n2.left);
    }


    /**
     *  BINARY TREES
     *
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Say we have 2 arrays, PRE and IN.
     * Preorder traversing implies that PRE[0] is the root node.
     * Then we can find this PRE[0] in IN, say it's IN[5].
     * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
     * Recursively doing this on subarrays, we can build a tree out of it
     *
     * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
     * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
     * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
     *
     *          1
     *       2      3
     *    4     5
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNodeImpl buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNodeImpl root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public static TreeNodeImpl buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNodeImpl root = new TreeNodeImpl(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }



    public static void parseJsonResponsesYearModelType(){
        String autos = restGet("https://frontend.mercadolibre.com/sites/MLA/homes/motors/filters?nc=7372146378&&category=MLA58254&os=web");

        List<String[]> csvData = readCSV("c:\\testfiles\\Tabla valuación autos.csv");

        try{
            HashMap<Integer,String> vehiculeSegments=new HashMap<Integer,String>();
            HashMap<Integer,Integer> vehiculeYears=new HashMap<Integer,Integer>();

            vehiculeSegments.put(1,"SEDAN 3 PUERTAS");
            vehiculeSegments.put(2,"SEDAN 4 PUERTAS");
            vehiculeSegments.put(3,"SEDAN 5 PUERTAS");
            vehiculeSegments.put(4,"RURAL 5 PUERTAS");
            vehiculeSegments.put(5,"COUPE");
            vehiculeSegments.put(6,"DESCAPOTABLE");
            vehiculeSegments.put(7,"TODO TERRENO");
            vehiculeSegments.put(8,"CONVERTIBLE");
            vehiculeSegments.put(9,"FAMILIAR");
            vehiculeSegments.put(10,"SEDAN 2 PUERTAS");
            vehiculeSegments.put(11,"RURAL 3 PUERTAS");
            vehiculeSegments.put(12,"PICK-UP");
            vehiculeSegments.put(13,"PICK-UP CABINA SIMPLE");
            vehiculeSegments.put(14,"FURGON O UTILITARIO");
            vehiculeSegments.put(15,"FURGONETA");
            vehiculeSegments.put(16,"FURGONETA O UTILITARIO");
            vehiculeSegments.put(17,"PICK-UP CABINA DOBLE");
            vehiculeSegments.put(18,"PICK-UP CABINA Y MEDIA");
            vehiculeSegments.put(19,"FURGON");
            vehiculeSegments.put(20,"SIN ESPECIFICACION");
            vehiculeSegments.put(21,"TRANS.DE PASAJEROS");
            vehiculeSegments.put(22,"CHASIS C/CABINA");
            vehiculeSegments.put(23,"RURAL 4/5 PUERTAS");
            vehiculeSegments.put(24,"UTILITARIO");
            vehiculeSegments.put(25,"RURAL 4 PUERTAS");
            vehiculeSegments.put(26,"CAMION");
            vehiculeSegments.put(27,"SEDAN 3 PUERTAS CON PORTON");
            vehiculeSegments.put(28,"CHASIS CON CABINA DOBLE");
            vehiculeSegments.put(29,"CHASIS CON CABINA");
            vehiculeSegments.put(30,"CHASIS S/CABINA");
            vehiculeSegments.put(31,"TRANSPORTE DE PASAJEROS");
            vehiculeSegments.put(32,"MINIBUS");
            vehiculeSegments.put(33,"");
            vehiculeSegments.put(34,"PICK UP");
            vehiculeSegments.put(35,"JEEP");


            AtomicInteger vehiculeModelTypeId = new AtomicInteger(12358);
            AtomicInteger vehiculeYearId = new AtomicInteger(6295);
            AtomicInteger vehiculeModelId = new AtomicInteger(1955);
            AtomicInteger vehiculeSegmentId = new AtomicInteger(38);


            JSONParser parserAutos = new JSONParser();
            JSONObject jsonAutos = (JSONObject) parserAutos.parse(autos);

            JSONArray availableFiltersAutos = (JSONArray) jsonAutos.get("available_filters");

            JSONObject availableFiltersAutosObject = (JSONObject) availableFiltersAutos.get(0);

            JSONArray autosValues = (JSONArray) availableFiltersAutosObject.get("values");

            Iterator<JSONObject> iterator = autosValues.iterator();

            JSONObject json = null;

            Path pathVehiculeBrand = Paths.get("c:\\testfiles\\vehiculeBrand.txt");

            Path pathVehiculeModel = Paths.get("c:\\testfiles\\vehiculeModel.txt");

            Path pathVehiculeModelType = Paths.get("c:\\testfiles\\vehiculeModelType.txt");

            Path pathVehiculeSegment = Paths.get("c:\\testfiles\\vehiculeSegment.txt");

            Path pathVehiculeModelTypeModel = Paths.get("c:\\testfiles\\vehiculeModelTypeModel.txt");

            Path pathVehiculeYears = Paths.get("c:\\testfiles\\vehiculeYears.txt");

            String insert = "";


            while (iterator.hasNext()) {
                json = iterator.next();


                String id = (String) json.get("id");
                String name = (String) json.get("name");

                if(!id.equals("8266702") && !id.equals("2400406")){

                    insert = "INSERT INTO vehicule_brand (id,name,active,vehicule_type_id) VALUES (" + id + ",'" + name.toUpperCase() + "',false,3);" + System.lineSeparator();

                    System.out.println(insert);

//                 string -> bytes
                    Files.write(pathVehiculeBrand, insert.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);


                    String autosModelos = restGet("https://frontend.mercadolibre.com/sites/MLA/homes/motors/filters?nc=1005075911&&category=MLA58254&BRAND=" + id + "&os=web");

                    JSONObject jsonAutosModelos = (JSONObject) parserAutos.parse(autosModelos);

                    JSONArray availableFiltersAutosModelos = (JSONArray) jsonAutosModelos.get("available_filters");

                    JSONObject availableFiltersAutosModelosObject = (JSONObject) availableFiltersAutosModelos.get(0);

                    JSONArray autosModelosValues = (JSONArray) availableFiltersAutosModelosObject.get("values");

                    Iterator<JSONObject> iteratorAutosModelos = autosModelosValues.iterator();

                    JSONObject jsonAutosModelosObject = null;

//                System.out.println("----------------------------------------");

                    while (iteratorAutosModelos.hasNext()) {
                        vehiculeYears = new HashMap<Integer, Integer>();

                        jsonAutosModelosObject = iteratorAutosModelos.next();


                        String idModelo = (String) jsonAutosModelosObject.get("id");
                        String nameModelo = (String) jsonAutosModelosObject.get("name");

                        insert = "INSERT INTO vehicule_model (id,code,name,active,vehicule_brand_id) VALUES (" + vehiculeModelId.incrementAndGet() + "," + idModelo + ",'" + nameModelo.toUpperCase() + "',true," + id + ");" + System.lineSeparator();

                        System.out.println(insert);

                        // string -> bytes
                        Files.write(pathVehiculeModel, insert.getBytes(StandardCharsets.UTF_8),
                                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                        int vehiculeSegmentCurrentId = 0;
                        int vehiculeYearCurrentId = 0;


                        if (false)
                            for (int i = 0; i < csvData.size(); i++) {

                                if (name.toUpperCase().equalsIgnoreCase(csvData.get(i)[0].toUpperCase())
                                        && csvData.get(i)[1].toUpperCase().contains(nameModelo.toUpperCase())
//                                && (csvData.get(i)[1].toUpperCase().contains("BEETLE") && !csvData.get(i)[1].toUpperCase().startsWith("BEETLE"))
                                        && (csvData.get(i)[2].toUpperCase().equalsIgnoreCase("MOTOCICLETA")
                                        || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("CICLOMOTOR")
                                        || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("SCOOTER")
                                        || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("CUATRICICLO")
                                        || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("MOTOVEHICULO")
                                        || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("MOTONETA / SCOOTER")
                                        || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("TRICICLO")
                                        || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("TRICICLO DE CARGA"))) {


                                    if (name.toUpperCase().equalsIgnoreCase(csvData.get(i)[0].toUpperCase()) && csvData.get(i)[1].toUpperCase().startsWith(nameModelo.toUpperCase())) {
                                        if (!vehiculeSegments.containsValue(csvData.get(i)[2])) {
                                            vehiculeSegments.put(vehiculeSegmentId.incrementAndGet(), csvData.get(i)[2].toUpperCase());
                                            vehiculeSegmentCurrentId = vehiculeSegmentId.get();
                                        } else {
                                            vehiculeSegmentCurrentId = getKeyByValue(vehiculeSegments, csvData.get(i)[2]);
                                        }

                                        insert = "INSERT INTO vehicule_model_type (id,name,vehicule_segment_id) VALUES (" + vehiculeModelTypeId.incrementAndGet() + ",'" + csvData.get(i)[1].toUpperCase().trim() + "'," + vehiculeSegmentCurrentId + ");" + System.lineSeparator();

                                        Files.write(pathVehiculeModelType, insert.getBytes(StandardCharsets.UTF_8),
                                                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                                        int year = 2021;
                                        for (int j = 3; j < 28; j++) {
                                            if (!csvData.get(i)[j].isEmpty()) {
                                                if (!vehiculeYears.containsValue(year)) {
                                                    vehiculeYears.put(vehiculeYearId.incrementAndGet(), year);
                                                    vehiculeYearCurrentId = vehiculeYearId.get();
                                                } else {
                                                    vehiculeYearCurrentId = getKeyByValue(vehiculeYears, year);
                                                }

                                                insert = "INSERT INTO vehicule_year_modeltype (vehicule_model_type_id,vehicule_year_id) VALUES (" + vehiculeModelTypeId.get() + "," + vehiculeYearCurrentId + ");" + System.lineSeparator();

                                                Files.write(pathVehiculeModelTypeModel, insert.getBytes(StandardCharsets.UTF_8),
                                                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                                            }
                                            year--;
                                        }

                                        insert = System.lineSeparator();

                                        Files.write(pathVehiculeModelTypeModel, insert.getBytes(StandardCharsets.UTF_8),
                                                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                                    }

                                }

                            }

                        if (!vehiculeYears.isEmpty()) {
                            for (Map.Entry m : vehiculeYears.entrySet()) {

                                insert = "INSERT INTO vehicule_year (id,year,vehicule_model_id) VALUES (" + m.getKey() + "," + m.getValue() + "," + vehiculeModelId.get() + ");" + System.lineSeparator();

                                Files.write(pathVehiculeYears, insert.getBytes(StandardCharsets.UTF_8),
                                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);


                            }

                            insert = System.lineSeparator();

                            Files.write(pathVehiculeYears, insert.getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        }


                    }

                    insert = System.lineSeparator();

                    System.out.println(insert);

                    // string -> bytes
                    Files.write(pathVehiculeModel, insert.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);

//                System.out.println("----------------------------------------");
                }
            }

            insert = System.lineSeparator();

            System.out.println(insert);

            // string -> bytes
            Files.write(pathVehiculeBrand, insert.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            if(!vehiculeSegments.isEmpty()){
                for(Map.Entry m : vehiculeSegments.entrySet()){

                    insert = "INSERT INTO vehicule_segment (id,name) VALUES (" + m.getKey() + ",'" + m.getValue() + "');" + System.lineSeparator();

                    Files.write(pathVehiculeSegment, insert.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);


                }

                insert = System.lineSeparator();

                Files.write(pathVehiculeSegment, insert.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseJsonResponsesCustomModels(){

        List<String[]> csvData = readCSV("c:\\testfiles\\Tabla valuación autos.csv");

        try{
            HashMap<Integer,Integer> vehiculeYears=new HashMap<Integer,Integer>();
            HashMap<Integer,String> vehiculeSegments=new HashMap<Integer,String>();

            vehiculeSegments.put(1,"SEDAN 3 PUERTAS");
            vehiculeSegments.put(2,"SEDAN 4 PUERTAS");
            vehiculeSegments.put(3,"SEDAN 5 PUERTAS");
            vehiculeSegments.put(4,"RURAL 5 PUERTAS");
            vehiculeSegments.put(5,"COUPE");
            vehiculeSegments.put(6,"DESCAPOTABLE");
            vehiculeSegments.put(7,"TODO TERRENO");
            vehiculeSegments.put(8,"CONVERTIBLE");
            vehiculeSegments.put(9,"FAMILIAR");
            vehiculeSegments.put(10,"SEDAN 2 PUERTAS");
            vehiculeSegments.put(11,"RURAL 3 PUERTAS");
            vehiculeSegments.put(12,"PICK-UP");
            vehiculeSegments.put(13,"PICK-UP CABINA SIMPLE");
            vehiculeSegments.put(14,"FURGON O UTILITARIO");
            vehiculeSegments.put(15,"FURGONETA");
            vehiculeSegments.put(16,"FURGONETA O UTILITARIO");
            vehiculeSegments.put(17,"PICK-UP CABINA DOBLE");
            vehiculeSegments.put(18,"PICK-UP CABINA Y MEDIA");
            vehiculeSegments.put(19,"FURGON");
            vehiculeSegments.put(20,"SIN ESPECIFICACION");
            vehiculeSegments.put(21,"TRANS.DE PASAJEROS");
            vehiculeSegments.put(22,"CHASIS C/CABINA");
            vehiculeSegments.put(23,"RURAL 4/5 PUERTAS");
            vehiculeSegments.put(24,"UTILITARIO");
            vehiculeSegments.put(25,"RURAL 4 PUERTAS");
            vehiculeSegments.put(26,"CAMION");
            vehiculeSegments.put(27,"SEDAN 3 PUERTAS CON PORTON");
            vehiculeSegments.put(28,"CHASIS CON CABINA DOBLE");
            vehiculeSegments.put(29,"CHASIS CON CABINA");
            vehiculeSegments.put(30,"CHASIS S/CABINA");
            vehiculeSegments.put(31,"TRANSPORTE DE PASAJEROS");
            vehiculeSegments.put(32,"MINIBUS");
            vehiculeSegments.put(33,"");
            vehiculeSegments.put(34,"PICK UP");
            vehiculeSegments.put(35,"JEEP");
            vehiculeSegments.put(36,"TRACTOR DE CARRETERA");
            vehiculeSegments.put(37,"MIDIBUS");
            vehiculeSegments.put(38,"MINIBUS (O MICROOMNIBUS)");
            vehiculeSegments.put(39,"MOTOCICLETA");
            vehiculeSegments.put(40,"SCOOTER");
            vehiculeSegments.put(41,"MOTONETA / SCOOTER");
            vehiculeSegments.put(42,"CUATRICICLO");
            vehiculeSegments.put(43,"ARENERO");
            vehiculeSegments.put(44,"TRICICLO");

            AtomicInteger vehiculeModelTypeId = new AtomicInteger(13408);
            AtomicInteger vehiculeYearId = new AtomicInteger(10245);
            AtomicInteger vehiculeModelId = new AtomicInteger(6911);
            AtomicInteger vehiculeSegmentId = new AtomicInteger(44);


            JSONObject json = null;

            Path pathVehiculeBrand = Paths.get("c:\\testfiles\\vehiculeBrand.txt");

            Path pathVehiculeModel = Paths.get("c:\\testfiles\\vehiculeModel.txt");

            Path pathVehiculeModelType = Paths.get("c:\\testfiles\\vehiculeModelType.txt");

            Path pathVehiculeSegment = Paths.get("c:\\testfiles\\vehiculeSegment.txt");

            Path pathVehiculeModelTypeModel = Paths.get("c:\\testfiles\\vehiculeModelTypeModel.txt");

            Path pathVehiculeYears = Paths.get("c:\\testfiles\\vehiculeYears.txt");

            String insert = "";

            JSONParser parserAutos = new JSONParser();


                String id = "108389";
                String name = "ZANELLA";


                String autosModelos = restGet("https://frontend.mercadolibre.com/sites/MLA/homes/motors/filters?nc=1005075911&&category=MLA1763&BRAND=" + id + "&os=web");

                JSONObject jsonAutosModelos = (JSONObject) parserAutos.parse(autosModelos);

                JSONArray availableFiltersAutosModelos = (JSONArray) jsonAutosModelos.get("available_filters");

                JSONObject availableFiltersAutosModelosObject = (JSONObject) availableFiltersAutosModelos.get(0);

                JSONArray autosModelosValues = (JSONArray) availableFiltersAutosModelosObject.get("values");

                Iterator<JSONObject> iteratorAutosModelos = autosModelosValues.iterator();

                JSONObject jsonAutosModelosObject = null;

//                System.out.println("----------------------------------------");

//            List<String> models = new ArrayList<>();
//            models.add("A");
//            models.add("B");
//            models.add("E");
//            models.add("A");

                while (iteratorAutosModelos.hasNext()) {
                    vehiculeYears = new HashMap<Integer,Integer>();

                    jsonAutosModelosObject = iteratorAutosModelos.next();


                    String idModelo = (String) jsonAutosModelosObject.get("id");
                    String nameModelo = (String) jsonAutosModelosObject.get("name");

                    insert = "INSERT INTO vehicule_model (id,code,name,active,vehicule_brand_id) VALUES (" + vehiculeModelId.incrementAndGet() + "," + idModelo + ",'" + nameModelo.toUpperCase() + "',true," + id + ");" + System.lineSeparator();

                    System.out.println(insert);

                    // string -> bytes
                    Files.write(pathVehiculeModel, insert.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                    int vehiculeSegmentCurrentId = 0;
                    int vehiculeYearCurrentId = 0;

                    String vehiculeModelIdOld = "1910";
                    if(nameModelo.toUpperCase().equalsIgnoreCase("STYLER 250 CRUISER"))
                    for(int i=0;i<csvData.size();i++){

                        if(name.toUpperCase().equalsIgnoreCase(csvData.get(i)[0].toUpperCase())
                                && csvData.get(i)[1].toUpperCase().contains("STYLER 250 CRUISER") //&& csvData.get(i)[1].toUpperCase().contains("300") //&& csvData.get(i)[1].toUpperCase().contains("XL")
//                                && (csvData.get(i)[1].toUpperCase().contains("BEETLE") && !csvData.get(i)[1].toUpperCase().startsWith("BEETLE"))
                                && (csvData.get(i)[2].toUpperCase().equalsIgnoreCase("MOTOCICLETA")
                                || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("SCOOTER")
                                || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("MOTONETA / SCOOTER")
                                || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("CUATRICICLO")
                                || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("ARENERO")
                                || csvData.get(i)[2].toUpperCase().equalsIgnoreCase("TRICICLO"))) {

                            /*if ((nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("C") && !csvData.get(i)[1].toUpperCase().startsWith("CL"))
                                        || (nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("CL") && (!csvData.get(i)[1].toUpperCase().startsWith("CLA")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("CLC")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("CLS")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("CLK")))
                                        || (nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("S") && (!csvData.get(i)[1].toUpperCase().startsWith("SL") && !csvData.get(i)[1].toUpperCase().startsWith("SPRINTER")))
                                        || (nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("SL") && (!csvData.get(i)[1].toUpperCase().startsWith("SLK")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("SLS")))
                                        || (nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("G") && !csvData.get(i)[1].toUpperCase().startsWith("GL"))
                                        || (nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("GL") && (!csvData.get(i)[1].toUpperCase().startsWith("GLA")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("GLB")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("GLC")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("GLE")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("GLK")
                                    && !csvData.get(i)[1].toUpperCase().startsWith("GLS")))
                                        || models.contains(nameModelo.substring(nameModelo.indexOf(" ") + 1))
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("GLA")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("GLB")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("GLC")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("GLE")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("GLK")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("GLS")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("SLK")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("SLS")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("CLA")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("CLS")
                                    || nameModelo.substring(nameModelo.indexOf(" ") + 1).equalsIgnoreCase("CLC")){*/

                                if (!vehiculeSegments.containsValue(csvData.get(i)[2])) {
                                    vehiculeSegments.put(vehiculeSegmentId.incrementAndGet(), csvData.get(i)[2].toUpperCase());
                                    vehiculeSegmentCurrentId = vehiculeSegmentId.get();
                                } else {
                                    vehiculeSegmentCurrentId = getKeyByValue(vehiculeSegments, csvData.get(i)[2]);
                                }


                            insert = "INSERT INTO vehicule_model_type (id,name,vehicule_segment_id) VALUES (" + vehiculeModelTypeId.incrementAndGet() + ",'" + csvData.get(i)[1].toUpperCase() + "'," + vehiculeSegmentCurrentId + ");" + System.lineSeparator();
//                            insert = "INSERT INTO vehicule_model_type (id,name,vehicule_segment_id) VALUES (" + vehiculeModelTypeId.incrementAndGet() + ",'" + csvData.get(i)[1].toUpperCase() + "'," + vehiculeSegmentCurrentId + ");" + System.lineSeparator();

                            Files.write(pathVehiculeModelType, insert.getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                            int year = 2021;
                            for (int j = 3; j < 28; j++) {
                                if (!csvData.get(i)[j].isEmpty()) {
                                    if (!vehiculeYears.containsValue(year)) {
                                        vehiculeYears.put(vehiculeYearId.incrementAndGet(), year);
                                        vehiculeYearCurrentId = vehiculeYearId.get();
                                    } else {
                                        vehiculeYearCurrentId = getKeyByValue(vehiculeYears, year);
                                    }

                                    insert = "INSERT INTO vehicule_year_modeltype (vehicule_model_type_id,vehicule_year_id) VALUES (" + vehiculeModelTypeId.get() + "," + vehiculeYearCurrentId + ");" + System.lineSeparator();

                                    Files.write(pathVehiculeModelTypeModel, insert.getBytes(StandardCharsets.UTF_8),
                                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                                }
                                year--;
                            }

                            insert = System.lineSeparator();

                            Files.write(pathVehiculeModelTypeModel, insert.getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                            }
//                        }

                    }

                    if(!vehiculeYears.isEmpty()){
                        for(Map.Entry m : vehiculeYears.entrySet()){

                            insert = "INSERT INTO vehicule_year (id,year,vehicule_model_id) VALUES (" + m.getKey() + "," + m.getValue() + "," + vehiculeModelIdOld + ");" + System.lineSeparator();

                            Files.write(pathVehiculeYears, insert.getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);


                        }

                        insert = System.lineSeparator();

                        Files.write(pathVehiculeYears, insert.getBytes(StandardCharsets.UTF_8),
                                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    }


                }

                insert = System.lineSeparator();

                System.out.println(insert);

                // string -> bytes
                Files.write(pathVehiculeModel, insert.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

//                System.out.println("----------------------------------------");


            insert = System.lineSeparator();

            System.out.println(insert);

            // string -> bytes
            Files.write(pathVehiculeBrand, insert.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);


            if(!vehiculeSegments.isEmpty()){
                for(Map.Entry m : vehiculeSegments.entrySet()){

                    insert = "INSERT INTO vehicule_segment (id,name) VALUES (" + m.getKey() + ",'" + m.getValue() + "');" + System.lineSeparator();

                    Files.write(pathVehiculeSegment, insert.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);


                }

                insert = System.lineSeparator();

                Files.write(pathVehiculeSegment, insert.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }


            System.out.println(vehiculeModelTypeId.get());
            System.out.println(vehiculeYearId.get());
            System.out.println(vehiculeModelId.get());
            System.out.println(vehiculeSegmentId.get());

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static List<String[]>  readCSV(String fileName) {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
        try(CSVReader reader = new CSVReaderBuilder(
                new FileReader(fileName))
                .withCSVParser(csvParser)   // custom CSV parser
                .withSkipLines(1)           // skip the first line, header info
                .build()){

            List<String[]> r = reader.readAll();
//            for(int i=0;i<r.size();i++){
//                System.out.println(r.get(i)[0] + " " + r.get(i)[1] + " etc...");
//            }

//            String[] lineInArray;
//            while ((lineInArray = reader.readNext()) != null) {
//                System.out.println(lineInArray[0] + " " + lineInArray[1] + " etc...");
//            }

            return r;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void parseJsonResponses(){
        String autos = restGet("https://frontend.mercadolibre.com/sites/MLA/homes/motors/filters?nc=1754239480&&category=MLA1907&os=web");

        try{
            JSONParser parserAutos = new JSONParser();
            JSONObject jsonAutos = (JSONObject) parserAutos.parse(autos);

            JSONArray availableFiltersAutos = (JSONArray) jsonAutos.get("available_filters");

            JSONObject availableFiltersAutosObject = (JSONObject) availableFiltersAutos.get(0);

            JSONArray autosValues = (JSONArray) availableFiltersAutosObject.get("values");

            Iterator<JSONObject> iterator = autosValues.iterator();

            JSONObject json = null;

            Path pathVehiculeBrand = Paths.get("c:\\testfiles\\vehiculeBrand.txt");

            Path pathVehiculeModel = Paths.get("c:\\testfiles\\vehiculeModel.txt");

            String insert = "";

            while (iterator.hasNext()) {
                json = iterator.next();


                String id = (String) json.get("id");
                String name = (String) json.get("name");

                insert = "INSERT INTO vehicule_brand (id,name,active,vehicule_type_id) VALUES (" + id + ",'" + name + "',true,5);" + System.lineSeparator();

                System.out.println(insert);

                // string -> bytes
                Files.write(pathVehiculeBrand, insert.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);


                String autosModelos = restGet("https://frontend.mercadolibre.com/sites/MLA/homes/motors/filters?nc=1005075911&&category=MLA1907&BRAND=" + id + "&os=web");

                JSONObject jsonAutosModelos = (JSONObject) parserAutos.parse(autosModelos);

                JSONArray availableFiltersAutosModelos = (JSONArray) jsonAutosModelos.get("available_filters");

                JSONObject availableFiltersAutosModelosObject = (JSONObject) availableFiltersAutosModelos.get(0);

                JSONArray autosModelosValues = (JSONArray) availableFiltersAutosModelosObject.get("values");

                Iterator<JSONObject> iteratorAutosModelos = autosModelosValues.iterator();

                JSONObject jsonAutosModelosObject = null;

//                System.out.println("----------------------------------------");

                while (iteratorAutosModelos.hasNext()) {
                    jsonAutosModelosObject = iteratorAutosModelos.next();


                    String idModelo = (String) jsonAutosModelosObject.get("id");
                    String nameModelo = (String) jsonAutosModelosObject.get("name");

                    insert = "INSERT INTO vehicule_model (id,name,active,vehicule_brand_id) VALUES (" + idModelo + ",'" + nameModelo + "',true," + id + ");" + System.lineSeparator();

                    System.out.println(insert);

                    // string -> bytes
                    Files.write(pathVehiculeModel, insert.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                }

                insert = System.lineSeparator();

                System.out.println(insert);

                // string -> bytes
                Files.write(pathVehiculeModel, insert.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

//                System.out.println("----------------------------------------");

            }

            insert = System.lineSeparator();

            System.out.println(insert);

            // string -> bytes
            Files.write(pathVehiculeBrand, insert.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void  generateHTMLFromPDF() {
        try {
            PDDocument pdf = PDDocument.load(new File("c:\\testfiles\\DNRPA-01-01-2021.pdf"));
            Writer output = new PrintWriter("c:\\testfiles\\pdf.html", "utf-8");
            new PDFDomTree().writeText(pdf, output);

            output.close();

        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void readLine(){
        String line = "I C9919001 M C99 19 001 APPIA ANDINA 110 MOTOCICLETA 16900 15300 13700 12600";

        String regex = "\\b[0-9]{2}\\b";

        System.out.println(line.replaceFirst(regex,"1111111111"));

        regex = "\\b[0-9]{3}\\b";

        System.out.println(line.replaceFirst(regex,"222222222"));

        line = line.substring(0,line.indexOf(" MOTOCICLETA"));

        System.out.println(line);

    }


    public static void readPdfDnrpa(){
        try (PDDocument document = PDDocument.load(new File("c:\\testfiles\\DNRPA-01-01-2021.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
//                System.out.println("Marca: " + lines[0].substring());

                 int count = 0;

                String regex = "\\b[0-9]{2}\\b";

                String regex2 = "\\b[0-9]{3}\\b";

                List<String> formated = new ArrayList<>();

                for (String line : lines) {
                    if(line.contains(" MOTOCICLETA")) {

                        line = line.replaceFirst(regex,"1111111111");

                        line = line.replaceFirst(regex2,"222222222");

                        line = line.replaceFirst(regex,"1111111111");

                        line = line.replaceFirst(regex2,"222222222");



                        line = line.substring(0,line.indexOf(" MOTOCICLETA"));

                        System.out.println(line);

                        formated.add(line);

                        count ++;
                    }
                }


                System.out.println("Total motocicletas: " + count);

            }

        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String restGet(String endpoint){
        try {

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
//            System.out.println("Output from Server .... \n");

            String response = "";
            while ((output = br.readLine()) != null) {
                response = response + output;
            }

            conn.disconnect();

            return response;

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;
    }

    public static String restPut(String endpoint, String payload){
        try {

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Accept", "application/json, text/plain, */*");
            conn.setRequestProperty("Content-type", "application/json, text/plain, */*");
//            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Accept-Lenguage", "es-419,es;q=0.9,en;q=0.8,gl;q=0.7");
            conn.setRequestProperty("Cookie", "dejavu=%7B%22session%22%3A%22%22%2C%22abt%22%3A%220.05472607669472851%22%7D; onboarding_cp=false; _fbp=fb.2.1549541605289.743810558; ftid=hGQ4LW3xGZ09CHtQiRKVfWaayctVfnfv-1511837042237; dvid=d3076074-2599-4dac-b596-5dbb3442d0a1-1589297181670; _mlt=e6577362-676a-4bdf-8934-2500a4459977; ken_gclid=CjwKCAjwmf_4BRABEiwAGhDfSW9_YkaXEVoBXH2Ce5zR5KdUjgDQSo_LK6IO7u-idpXCD-oLi3nrRxoCAXQQAvD_BwE; _d2id=6b69c39c-9f6b-46ca-bb43-236fe3809506; _hjid=6d779442-3056-44ad-8705-77ba28707967; _ml_ga=GA1.3.2077015265.1601304808; _ml_cbanner_mla=1; ssid=ghy-110321-Iejzq1yANH5SMZzxMk6orHKgumhAYg-__-33533529-__-1699060860469--RRR_0-RRR_0; orguseridp=33533529; orgnickp=PETERS-8; orghash=110321-MLAornHGSx5mSAo1XBx8vKv17uowl7__RRR_0__RRR_0-33533529; orguserid=dHHZ9THH9Z4; __gads=ID=a6fe5f9aba61e326:T=1601571851:R:S=ALNI_MaJVPlfEVU9EXseSBmQOoz7Mc-s7w; _gcl_au=1.1.1230465097.1612815011; __utma=1.1878331114.1579970464.1593978195.1613421544.6; __utmz=1.1613421544.6.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _gac_UA-46085787-1=1.1614171293.Cj0KCQiAj9iBBhCJARIsAE9qRtCyGSqDG6CtwAvMbfQHPRhz-jCpejMk6aLcGBw3DB363YmIMeVT0DEaAuf9EALw_wcB; tooltips-configuration={\"credits_tooltip\":{\"view_cnt\":6,\"close_cnt\":0,\"view_time\":1614625619,\"close_time\":0}}; nsa_rotok=eyJhbGciOiJIUzI1NiIsImtpZCI6IjEiLCJ0eXAiOiJKV1QifQ.eyJyb3RhdGlvbl9pZCI6IjdjMDM1MmY1LTlmODItNGU3MS1iYzZiLWE1MGExOWExZTY5MiIsInBsYXRmb3JtIjoiTUwiLCJyb3RhdGlvbl9kYXRlIjoxNjE1MjM3OTU2LCJleHBpcmUiOjE2MTUzMjM3NTYsImV4cCI6MTYxNzgyOTM1NiwianRpIjoiZjZjZWU1ZmQtZTc1Mi00NzE5LWEzZGQtN2U1YzA0NzViYTRjIiwiaWF0IjoxNjE1MjM3MzU2LCJzdWIiOiJmZDc3Y2JmMzEwMjY1NjAzYWVhNTczOWMxYmRiNzQ1ZjA1N2Y3MThlNjYxMGIxMmJhYTk2YjY2NGYzYWFkNzUwIn0.ordnxF7FTvK-7B-ulMTWT4prPfaomMB9IN15MReaMMk; _csrf=HrxG-V0YX0PMyO2iukS1anfv; cp=1426; _ml_ci=2077015265.1601304808; _hjTLDTest=1; c_ui-navigation=5.14.3; nx-time-track=41bbc571eab94db3ad3048324c9268db_1616512012517; _ml_ga_gid=GA1.3.210015709.1616960940; c_categories-desktop=1.60.0; JSESSIONID=8A0C06015DDC65F2E1F8913B0FBB935C; _hjIncludedInSessionSample=0; LAST_SEARCH=anillo%20piedra%20preciosa; navigation_searches=anillo%20piedra%20preciosa%7C29032021003631-appia%7C26032021184402-audi%20r8%7C25032021005613-licuadora%20philips%7C23032021174213-jarra%20phillips%7C23032021174011; NSESSIONID=s%3Afj4RmX2vGTdsSEt3HWBzRABAYScBhJo-.hKjTatooWaBT8dx%2F7Muc%2FR%2B0ozLw5f5sbFnwGjubJHU");
            conn.setRequestProperty("csrf-token", "HIgDaNKc-5IByNePRxTO6G3v-b18M95hKWt4");

            OutputStream os = conn.getOutputStream();
            os.write(payload.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }

            System.out.println("Output from Server .... \n");

            String response = "";
            while ((output = br.readLine()) != null) {
                response = response + output;
            }

            System.out.println(response);

            conn.disconnect();

            return response;

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;
    }

    public static JSONArray formatMeliPutResponse(String payload){
        try{
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(payload);
            JSONObject steps = (JSONObject) json.get("steps");
            JSONObject stepone = (JSONObject) steps.get("step_one");
            JSONArray bricks = (JSONArray) stepone.get("bricks");

            JSONObject aux = (JSONObject) bricks.get(0);

            JSONArray bricksofbricks = (JSONArray) aux.get("bricks");

            Iterator<JSONObject> iterator = bricksofbricks.iterator();

            JSONObject iteratedObj = null;
            JSONArray iteratedbricks = null;

            JSONObject iteratedObjx2 = null;

            Iterator<JSONObject> iterator2 = null;

            JSONObject data = null;

            while (iterator.hasNext()) {
                iteratedObj = iterator.next();

                if(iteratedObj.get("id").equals("category_task")){
                    iteratedbricks = (JSONArray) iteratedObj.get("bricks");

                    iterator2 = iteratedbricks.iterator();

                    while (iterator2.hasNext()) {
                        iteratedObjx2 = iterator2.next();

                        if(iteratedObjx2.get("id").equals("category_selector")){
                            data = (JSONObject) iteratedObjx2.get("data");

                            return (JSONArray) data.get("option_values");
                        }

                    }


                }

            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void readJsonFile(){
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("c:\\testfiles\\localidades.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            System.out.println("Object: " + jsonObject);

            Map provincias = new HashMap<>();

            JSONObject json = null;

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("localidades");

            System.out.println("msg: " +  msg);

            Iterator<JSONObject> iterator = msg.iterator();

            FileWriter file = new FileWriter("c:\\testfiles\\inserts-cities.txt");

            BufferedWriter bw = new BufferedWriter(file);
            System.out.println("=========================");
            while (iterator.hasNext()) {
                json = iterator.next();


                JSONObject centroide = (JSONObject) json.get("centroide");

                JSONObject provincia = (JSONObject) json.get("provincia");

                System.out.println("INSERT INTO CITY (city_id, city_name, lat, lon, province_id) values (" + json.get("id") + ",'" + json.get("nombre").toString().replace("'","''") + "','" + centroide.get("lat") + "','" + centroide.get("lon") + "'," + provincia.get("id") + ");");

                provincias.put(provincia.get("id"),provincia.get("nombre"));


                bw.write("INSERT INTO CITY (city_id, city_name, lat, lon, province_id) values (" + json.get("id") + ",'" + json.get("nombre") + "','" + centroide.get("lat") + "','" + centroide.get("lon") + "'," + provincia.get("id") + ");\n");


            }

            System.out.println("=========================");

            file = new FileWriter("c:\\testfiles\\inserts-provinces.txt");

            bw = new BufferedWriter(file);
//
            for (Object key : provincias.keySet()) {
                System.out.println("INSERT INTO province (province_id, province_name, country_id) values (" + key.toString() + ",'" + provincias.get(key) + "'," + "1);");

                bw.write("INSERT INTO province (province_id, province_name, country_id) values (" + key.toString() + ",'" + provincias.get(key) + "'," + "1);\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


