package generators;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import templates.Addresses;

/**
 * Servlet implementation class Generators
 */
@WebServlet("/Generators")
public class Generators extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generators() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String InstanceDaoClassName ="ClassDao";
		String InstanceDaoClassNameOfVariableName ="ClassDaoVarName";
		String InstanceBeansClassName ="BeansEventDetailInfo";
		String InstanceBeansClassNameOfVariableName ="beansEventDetailInfo";
		String InstanceBeansClassNameOfVariableNameList ="beansEventDetailInfoList";
		String InstanceBeansClassNameOfVariableNameListOfVariableName ="分かりやすいリスト名";
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		int id = 0;
		String a2 = "title";
		String a3 = "img_name";
		String a4 = "summary";
		String a5 = "event_category";
		String a6 = "schedule";
		String a7 = "local_region";
		String a8 = "fees";
		String a9 = "access";
		String a10 = "qualification";
		String a11 = "presenter";
		String a12 = "organizer";
		String a13 = "13";
		String a14 = "14";
		String a15 = "15";



		System.out.println("private int id" + ";");
		System.out.println("private String" + " "+ a2 + ";");
		System.out.println("private String" + " "+ a3 + ";");
		System.out.println("private String" + " "+ a4 + ";");
		System.out.println("private String" + " "+ a5 + ";");
		System.out.println("private String" + " "+ a6 + ";");
		System.out.println("private String" + " "+ a7 + ";");
		System.out.println("private String" + " "+ a8 + ";");
		System.out.println("private String" + " "+ a9 + ";");
		System.out.println("private String" + " "+ a10 + ";");
		System.out.println("private String" + " "+ a11 + ";");
		System.out.println("private String" + " "+ a12 + ";");
		System.out.println("private String" + " "+ a13 + ";");
		System.out.println("private String" + " "+ a14 + ";");
		System.out.println("private String" + " "+ a15 + ";");



		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");

		System.out.println();


		System.out.println("set変数名の頭文字を大文字にするだけでＯＫ！！");
		System.out.println();
		System.out.println();


		System.out.println("ArrayList<" + InstanceBeansClassName + ">" + " " + InstanceBeansClassNameOfVariableNameList + " = new ArrayList<" + InstanceBeansClassName + ">();");
		System.out.println();

		System.out.println("while (rs.next()) {");

			System.out.println(InstanceBeansClassName +" "+ InstanceBeansClassNameOfVariableName +" "+ "=" +" "+ "new" +" "+ InstanceBeansClassName + "();");

			System.out.println(InstanceBeansClassNameOfVariableName + "." + "setId(rs.getInt(\"id\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a2 + "(rs.getString(\"" + a2 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a3 + "(rs.getString(\"" + a3 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a4 + "(rs.getString(\"" + a4 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a5 + "(rs.getString(\"" + a5 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a6 + "(rs.getString(\"" + a6 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a7 + "(rs.getString(\"" + a7 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a8 + "(rs.getString(\"" + a8 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a9 + "(rs.getString(\"" + a9 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a10 + "(rs.getString(\"" + a10 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a11 + "(rs.getString(\"" + a11 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a12 + "(rs.getString(\"" + a12 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a13 + "(rs.getString(\"" + a13 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a14 + "(rs.getString(\"" + a14 +"\"));");
			System.out.println(InstanceBeansClassNameOfVariableName + "." + "set" + a15 + "(rs.getString(\"" + a15 +"\"));");

			System.out.println();
			System.out.println(InstanceBeansClassNameOfVariableNameList + ".add(" + InstanceBeansClassNameOfVariableName +  ");");
		System.out.println("}");


		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();










		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();

		System.out.println(
				  "(int id, String " + a2 + ", String " + a3 + ", String " + a4 + ", String " + a5 + ", String " + a6
    		+ ", String " + a7 + ", String " + a8 + ", String " + a9 + ", String " + a10 + ", String " + a11
    		+ ", String " + a12 + ", String " + a13 + ", String " + a14 + ", String " + a15 + ")" );

		System.out.println();
		System.out.println(
				  "(id, " + a2 + ", " + a3 + ", " + a4 + ", " + a5 + ", " + a6
  		+ ", " + a7 + ", " + a8 + ", " + a9 + ", " + a10 + ", " + a11
  		+ ", " + a12 + ", " + a13 + ", " + a14 + ", " + a15 + ")" );





		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
















		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();







		request.getRequestDispatcher(Addresses.TOP_PAGE).forward(request, response);

	}


/*




------------------------------------------------------------------------------------------------------------------------------------------------------------
	bdb.setBuyDate(rs.getTimestamp("create_date"));
------------------------------------------------------------------------------------------------------------------------------------------------------------
	bdbList.add(bdb11);






------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------




*/


}
