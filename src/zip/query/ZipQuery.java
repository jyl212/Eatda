package zip.query;

/*
SQL> desc zip;
	Name	 Null?    Type
	SIDO	NOT NULL VARCHAR2(6)
	GUGUN	NOT NULL VARCHAR2(100)
*/

public class ZipQuery {
	public static String ZIP_SIDO = "select distinct SIDO from zip order by SIDO";
	public static String ZIP_GUGUN = "SELECT distinct substr(GUGUN,1,instr(GUGUN,' ')-1) gu  from zip A where SIDO=?   and GUGUN like '% %' "
			+ "UNION "
			+ "select distinct GUGUN gu from zip b where SIDO=?  and GUGUN not like '% %' "
			+ "ORDER BY gu";

}