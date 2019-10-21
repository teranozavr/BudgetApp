package com.github.teranozavr.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.github.teranozavr.utils.PropertiesReader;

public class HtmlReporter {

    private static String getReportFileName() throws IOException{
        return PropertiesReader.getInstance().getReoprtProperty("report.file");
    }

    private static String getTestResultsVariable() throws IOException{
        return PropertiesReader.getInstance().getReoprtProperty("testResults.variable");
    }

    public static void copyTemplateToReport() throws IOException {
        String inputFile = PropertiesReader.getInstance().getReoprtProperty("reportTemplate.file");
        String outputFile = getReportFileName();
        copyData(inputFile,outputFile,true);
    }

    private static void copyData(String in, String out, boolean createNewFile)throws IOException{
        if (createNewFile) {
            File file = new File(out);
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        copyData(in,out);
    }

    private static void copyData(String in, String out) throws IOException{
        writeFile(readFile(in),out);
    }

    private static List<String> readFile(String fileName) throws IOException{
        List<String> lines = new ArrayList<>();
        String line;
        java.io.FileReader fileReader = new java.io.FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines;
    }

    private static void writeReportFile(List<String> strings) throws IOException{
        writeFile(strings, getReportFileName());
    }

    private static void writeFile(List<String> strings, String fileName) throws IOException{
        File outputFile = new File(fileName);
        FileWriter writer = new FileWriter(outputFile);
        for(String st : strings) {
            writer.write(st+'\n');
        }
        writer.close();
    }

    public static void writeTestResultTable(List<String> columnNames) throws IOException
    {
        String table= "<table style=\"border: 1;margin: 10.0px;\">"+'\n'+"<tbody>"+'\n'+"<tr>"+'\n';
        if(columnNames.size()==3)
        {
            table+="<colgroup> <col style=\"width: 616.0px;\"/><col style=\"width: 303.0px;\"/> <col style=\"width: 160.0px;\"/> </colgroup>";
        }
        for(String colunmName : columnNames) {
            table+="<th align = \"center\">"+colunmName+"</th>"+'\n';
        }
        table+="</tr></tbody></table>";
        insertToReport(getTestResultsVariable(), table);
    }

    public static void writeTestName(String str) throws IOException {
       String testName = "<tr>"+"<th align = \"left\">"+str+"</th>";
        insertToReport("</tr></tbody></table>"+getTestResultsVariable(), testName);
    }

    private static void  insertToReport(String str1, String str2) throws IOException
    {
        insertToFile(str1, str2, getReportFileName());
    }

    private static void insertToFile(String str1, String str2, String fileName) throws IOException
    {
        List<String> strings = readFile(fileName);
        int i=0;
        for(String st : strings) {
            int index = st.indexOf(str1);
            if (index!=-1){
            strings.set(i, insertToString(st, index, str2));
            }
            i++;
        }
        writeReportFile(strings);
    }

    private static String insertToString(String s1, int ind, String s2)
    {
        return s1.substring(0,ind)+s2+s1.substring(ind,s1.length());
    }

    public static void writeTestResult(boolean res) throws IOException {
        String result = res?"<font color=\"green\">Успех</font>":"<font color=\"red\">Не успех</font>";
        String testResult = "<th align = \"center\">"+result+"</th></tr>\n";
        insertToReport("</tr></tbody></table>"+getTestResultsVariable(), testResult);
    }

    public static void writeTestResult() throws IOException {
        String testResult = "<th align = \"center\"><font color=\"gray\">Не тестировалось</font></th></tr>\n";
        insertToReport("</tr></tbody></table>"+getTestResultsVariable(), testResult);
    }
}
