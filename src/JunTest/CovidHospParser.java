package JunTest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import JunTest.CovidHospVO;

public class CovidHospParser {

	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public List<CovidHospVO> getHospInfo() {
		List<CovidHospVO> chList = new ArrayList<>(); 
		int page = 1;	 
		try{
			while(true){
				String url = "http://apis.data.go.kr/B551182/pubReliefHospService/getpubReliefHospList?serviceKey=lycEChYp17HBUpubmIggfvsSVH4hNI7Hnx1%2FzJk0L5ux02t%2FxJcg6EWrWWagsx3Z45wyalba2x9XAMlfvNKmdg%3D%3D&numOfRows=145&spclAdmTyCd=A0&pageNo="+page;
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				doc.getDocumentElement().normalize();
				
				NodeList nList = doc.getElementsByTagName("item");
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						CovidHospVO cv = new CovidHospVO();
						cv.setSidoNm(getTagValue("sidoNm", eElement));
						cv.setSgguNm(getTagValue("sgguNm", eElement));
						cv.setSpclAdmTyCd(getTagValue("spclAdmTyCd", eElement));
						cv.setYadmNm(getTagValue("yadmNm", eElement));
						cv.setTelno(getTagValue("telno", eElement));
						chList.add(cv);
						
					}	
				}	
				
				page += 1;
				if(page > 2){	
					break;
				}
			}	
			
		} catch (Exception e){	
			e.printStackTrace();
		}	
		return chList;
	}	

}	