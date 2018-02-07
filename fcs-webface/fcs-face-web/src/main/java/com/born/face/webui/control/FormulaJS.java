package com.born.face.webui.control;

public class FormulaJS {
  public FormulaJS() {
  }
  /**
   *<P><B>��ȡFormulaJS�ͻ��˽ű�</B></P>
   * @return String
   */
  public static String getFormulaJS()
  {
     JSTool jstool=new JSTool("Formula.js");
	if(!jstool.util.isUpdateJsEveryTime())
	 {
		 return jstool.getComponentJS() ;
	 }
     java.lang.StringBuffer  js=jstool.js;
	js.append("	///��ʽ���㵥Ԫ\r\n");
	js.append("	function SourceCellIndex(){\r\n");
	js.append("		this.expression=\"\";\r\n");
	js.append("		this.index=-1;\r\n");
	js.append("	}\r\n");
	js.append("\r\n");
	js.append("	///��ʽ\r\n");
	js.append("	function Formula(tableId,expression){\r\n");
	js.append("		///��ʽ���ڵ�table\r\n");
	js.append("		this.table=document.getElementById(tableId);\r\n");
	js.append("		///��ʽ��ԭʼ���ʽ\r\n");
	js.append("		this.expression=expression;\r\n");
	js.append("		///��ʽ�����õĵ�Ԫ��\r\n");
	js.append("		this.targetCell=null;\r\n");
	js.append("		///��ʽ���㵥Ԫ\r\n");
	js.append("		this.sourceCells=new Array();\r\n");
	js.append("\r\n");
	js.append("		///��ݱ��ʽ����ù�ʽ���㵥Ԫ\r\n");
	js.append("		///���иù�ʽ\r\n");
	js.append("		this.exe=Formula_exe;\r\n");
	js.append("\r\n");
	js.append("	}\r\n");
	js.append("	function Formula_setRealExpression(objFormula,expressionIndex){\r\n");
	js.append("			var expression=objFormula.expression[expressionIndex];\r\n");
	js.append("			var arrayExpression=expression.split(\"=\");\r\n");
	js.append("			var beginIndex=arrayExpression[0].indexOf(\"[\");\r\n");
	js.append("			var endIndex=arrayExpression[0].indexOf(\"]\");\r\n");
	js.append("			var columnName=expression.substring(beginIndex+1,endIndex);\r\n");
	js.append("			var index=WebGrid_getColumnIndex(objFormula.table.id,columnName);\r\n");
	js.append("			objFormula.sourceCells[expressionIndex]=new SourceCellIndex();\r\n");
	js.append("			objFormula.sourceCells[expressionIndex].index=index;\r\n");
	js.append("			/*\r\n");
	js.append("			var Editors =eval(objFormula.table.id+\"_Editors\");\r\n");
	js.append("			var editorSource=Editors[index];\r\n");
	js.append("			var control=editor.getChild();\r\n");
	js.append("			var getValue=control.getAttribute(\"getValue\");\r\n");
	js.append("			var value=\"0\";\r\n");
	js.append("			if(getValue!=null)\r\n");
	js.append("			{\r\n");
	js.append("				var value=eval(getValue+\"('\"+control.id+\"')\");\r\n");
	js.append("			}\r\n");
	js.append("			*/\r\n");
	js.append("			while(arrayExpression[1].indexOf(\"[\")>=0)\r\n");
	js.append("			{\r\n");
	js.append("				beginIndex=arrayExpression[1].indexOf(\"[\");\r\n");
	js.append("				endIndex=arrayExpression[1].indexOf(\"]\");\r\n");
	js.append("				columnName=arrayExpression[1].substring(beginIndex+1,endIndex);				\r\n");
	js.append("				var editor=WebGrid_getEditorByColumnName(objFormula.table.id,columnName);\r\n");
	js.append("				var control=editor.getChild();\r\n");
	js.append("				var value=\"0\";\r\n");
	js.append("				if(control==null)\r\n");
	js.append("				{\r\n");
	js.append("					var index=WebGrid_getColumnIndex(objFormula.table.id,columnName);\r\n");
	js.append("					var hidden=WebGrid_getColumnText(objFormula.table.id,index);\r\n");
	js.append("					var editRow=WebGrid_getExistEditRow(objFormula.table);\r\n");
	js.append("					if(editRow!=null)\r\n");
	js.append("					{\r\n");
	js.append("						value=ListManager_Get(editRow.rowIndex,hidden);\r\n");
	js.append("\r\n");
	js.append("					}					\r\n");
	js.append("				}\r\n");
	js.append("				else\r\n");
	js.append("				{\r\n");
	js.append("					var getValue=control.getAttribute(\"getValue\");\r\n");
	js.append("					\r\n");
	js.append("					if(getValue!=null)\r\n");
	js.append("					{\r\n");
	js.append("						value=eval(getValue+\"('\"+control.id+\"')\");\r\n");
	js.append("					}\r\n");
	js.append("					else\r\n");
	js.append("					{\r\n");
	js.append("						var hidden=WebGrid_getColumnText(objFormula.table.id,index);\r\n");
	js.append("						if(editRow!=null)\r\n");
	js.append("						{\r\n");
	js.append("							value=ListManager_Get(editRow.rowIndex,hidden);\r\n");
	js.append("						}\r\n");
	js.append("					}\r\n");
	js.append("		\r\n");
	js.append("				}\r\n");
	js.append("				if(value!=0)\r\n");
	js.append("				{\r\n");
	js.append("					value=value.replace(/,/g,\"\");\r\n");
	js.append("					value=value.replace(/\\s/g,\"\");\r\n");
	js.append("				}\r\n");
	js.append("				if(value==\"\")\r\n");
	js.append("				{\r\n");
	js.append("					value=0;\r\n");
	js.append("				}\r\n");
	js.append("				\r\n");
	js.append("				var strTempFirst=arrayExpression[1].substring(0,beginIndex);\r\n");
	js.append("				var strTempLast=arrayExpression[1].substring(endIndex+1);\r\n");
	js.append("				arrayExpression[1]=strTempFirst+\"(\"+value+\")\"+strTempLast;\r\n");
	js.append("			}\r\n");
	js.append("			objFormula.sourceCells[expressionIndex].expression=arrayExpression[1];\r\n");
	js.append("	}\r\n");
	js.append("	function Formula_getJsCellValue(jsCell){\r\n");
	js.append("		if(jsCell==null)	return null;\r\n");
	js.append("\r\n");
	js.append("		if(jsCell.getValue().indexOf(\",\")>-1){\r\n");
	js.append("			if(jsCell.child.type=='lable'){\r\n");
	js.append("				tempValue=replaceAll(jsCell.getValue(),',','');;\r\n");
	js.append("				curValue=parseFloat(tempValue);\r\n");
	js.append("				if(curValue.toString()!='NaN')\r\n");
	js.append("					return curValue;\r\n");
	js.append("			}\r\n");
	js.append("			return null;\r\n");
	js.append("		}\r\n");
	js.append("		else{\r\n");
	js.append("			curValue=parseFloat(jsCell.getValue());\r\n");
	js.append("			if(curValue.toString()=='NaN'){\r\n");
	js.append("				return null;\r\n");
	js.append("			}\r\n");
	js.append("			else{\r\n");
	js.append("				return curValue;\r\n");
	js.append("			}\r\n");
	js.append("		}\r\n");
	js.append("\r\n");
	js.append("	}		///���һ����ʽ���㵥Ԫ\r\n");
	js.append("	function Formula_addSourceCell(sourceCell){\r\n");
	js.append("		this.sourceCells.push(sourceCell);\r\n");
	js.append("		if(sourceCell.jsCell!=null)	sourceCell.jsCell.sourceFormulas.push(this);\r\n");
	js.append("	}\r\n");
	js.append("	//����ϼ�\r\n");
	js.append("	function Formula_runSum(table,dataField)\r\n");
	js.append("	{\r\n");
	js.append("		var index=WebGrid_getColumnIndex(table.id,dataField);\r\n");
	js.append("		var hidden=WebGrid_getColumnText(table.id,index);\r\n");
	js.append("		var strArray=ListManager_Analysis(hidden);\r\n");
	js.append("		var sum=0;\r\n");
	js.append("		for(var i=0;i<strArray.length;i++)\r\n");
	js.append("		{\r\n");
	js.append("			var text=strArray[i];\r\n");
	js.append("			text=text.replace(/,/g,\"\");\r\n");
	js.append("			text=text.replace(/\\s/g,\"\");\r\n");
	js.append("			var numberValue=0;\r\n");
	js.append("			if(text!=\"\")\r\n");
	js.append("			{\r\n");
	js.append("				numberValue=parseFloat(text);\r\n");
	js.append("			}\r\n");
	js.append("			sum+=numberValue;\r\n");
	js.append("		}		\r\n");
	js.append("		var editor=WebGrid_getEditorByColumnName(table.id,dataField);\r\n");
	js.append("		var textObj=editor.getChild();\r\n");
	js.append("		var tableCellIndex=WebGrid_getColumnRealIndex(table.id,dataField)\r\n");
	js.append("		this.targetCell=document.getElementById(table.id+\"_footer\").rows[0].cells[tableCellIndex];\r\n");
	js.append("		var floatAll=Formula_ConvertData(sum.toString(), textObj.getAttribute(\"DecimalDigits\"),5);\r\n");
	js.append("		if(floatAll==0)\r\n");
	js.append("		{\r\n");
	js.append("			if(textObj.getAttribute(\"IsConvertZero\")==\"true\")\r\n");
	js.append("			{\r\n");
	js.append("				this.targetCell.innerText=\"\";\r\n");
	js.append("			}\r\n");
	js.append("		}\r\n");
	js.append("		else\r\n");
	js.append("		{\r\n");
	js.append("			WebGrid_setInnerText(this.targetCell,Formula_Convertformat(textObj,floatAll));\r\n");
	js.append("		}\r\n");
	js.append("	}\r\n");
	js.append("	///���㹫ʽ\r\n");
	js.append(" 	function Formula_exe()\r\n");
	js.append(" 	{\r\n");
	js.append(" 		var Editors =eval(this.table.id+\"_Editors\");\r\n");
	js.append(" 		var editRow=WebGrid_getExistEditRow(this.table);\r\n");
	js.append(" 		if(editRow==null)\r\n");
	js.append(" 		{\r\n");
	js.append(" 			return;\r\n");
	js.append(" 		}\r\n");
	js.append(" 		for(var i=0;i<this.expression.length;i++)\r\n");
	js.append(" 		{\r\n");
	js.append("			Formula_setRealExpression(this,i);\r\n");
	js.append("			var strTempExpression=this.sourceCells[i].expression.replace(/,/g,\"\");\r\n");
	js.append("			var editor=Editors[this.sourceCells[i].index];\r\n");
	js.append("			if(editor.isMutex)\r\n");
	js.append("			{\r\n");
	js.append("				var isRunExpression=true;\r\n");
	js.append("				for(var j=0;j<editor.mutexColumn.length;j++)\r\n");
	js.append("				{\r\n");
	js.append("						var columnIndex=WebGrid_getColumnIndex(this.table.id,editor.mutexColumn[j]);\r\n");
	js.append("						var hidden=WebGrid_getColumnText(this.table.id,columnIndex);\r\n");
	js.append("						var mutexColumnValue=ListManager_Get(editRow.rowIndex ,hidden);\r\n");
	js.append("						var mutexControl=Editors[columnIndex].getChild();\r\n");
	js.append("						if(mutexControl==null)\r\n");
	js.append("						{\r\n");
	js.append("							break;\r\n");
	js.append("						}\r\n");
	js.append("						if(mutexControl.getAttribute(\"IsConvertZero\")==\"true\")\r\n");
	js.append("						{\r\n");
	js.append("							if(mutexColumnValue!=\"0\"&&mutexColumnValue!=\"\")\r\n");
	js.append("							{\r\n");
	js.append("								isRunExpression=false;\r\n");
	js.append("								break;\r\n");
	js.append("							}\r\n");
	js.append("						}\r\n");
	js.append("						else\r\n");
	js.append("						{\r\n");
	js.append("							if(mutexColumnValue!='')\r\n");
	js.append("							{\r\n");
	js.append("								isRunExpression=false;\r\n");
	js.append("								break;\r\n");
	js.append("							}\r\n");
	js.append("						}\r\n");
	js.append("				}\r\n");
	js.append("				if(isRunExpression)\r\n");
	js.append("				{\r\n");
	js.append("					var textObj=editor.getChild();\r\n");
	js.append("					var textBoxValue=eval(strTempExpression);\r\n");
	js.append("					if(textBoxValue==Infinity)\r\n");
	js.append("					{\r\n");
	js.append("						textBoxValue=\"0\";\r\n");
	js.append("						continue;\r\n");
	js.append("					}\r\n");
	js.append("					if(isNaN(textBoxValue))\r\n");
	js.append("					{\r\n");
	js.append("						textBoxValue=\"0\";\r\n");
	js.append("						continue;\r\n");
	js.append("					}\r\n");
	js.append("					var hidden=WebGrid_getColumnText(this.table.id,this.sourceCells[i].index);\r\n");
	js.append("					if(textObj==null)\r\n");
	js.append("					{\r\n");
	js.append("						var cellIndex=WebGrid_getColumnRealIndex(this.table.id,editor.dataField);\r\n");
	js.append("						if(cellIndex!=-1)\r\n");
	js.append("						{\r\n");
	js.append("							var floatAll=Formula_ConvertData(textBoxValue.toString(), 2,5);\r\n");
	js.append("							var cell=editRow.cells[cellIndex];\r\n");
	js.append("							WebGrid_setInnerText(cell,floatAll);\r\n");
	js.append("						}\r\n");
	js.append("						ListManager_Set(editRow.rowIndex,textBoxValue,hidden);						\r\n");
	js.append("						continue;\r\n");
	js.append("					}\r\n");
	js.append("					var func=textObj.getAttribute(\"setValue\");\r\n");
	js.append("					var textBoxValue=eval(strTempExpression);\r\n");
	js.append("					eval(func+\"('\"+textObj.id+\"',\"+textBoxValue+\")\");					\r\n");
	js.append("					ListManager_Set(editRow.rowIndex,textBoxValue,hidden);\r\n");
	js.append("				}\r\n");
	js.append("\r\n");
	js.append("			}\r\n");
	js.append("			else\r\n");
	js.append("			{\r\n");
	js.append("				var textObj=editor.getChild()\r\n");
	js.append("				var textBoxValue=eval(strTempExpression);\r\n");
	js.append("				if(textBoxValue==Infinity)\r\n");
	js.append("				{\r\n");
	js.append("					textBoxValue=\"0\";\r\n");
	js.append("					continue;\r\n");
	js.append("				}\r\n");
	js.append("				if(isNaN(textBoxValue))\r\n");
	js.append("				{\r\n");
	js.append("					textBoxValue=\"0\";\r\n");
	js.append("					continue;\r\n");
	js.append("				}\r\n");
	js.append("				var hidden=WebGrid_getColumnText(this.table.id,this.sourceCells[i].index);\r\n");
	js.append("				if(textObj==null)\r\n");
	js.append("				{\r\n");
	js.append("					var cellIndex=WebGrid_getColumnRealIndex(this.table.id,editor.dataField);\r\n");
	js.append("					if(cellIndex!=-1)\r\n");
	js.append("					{\r\n");
	js.append("						var floatAll=Formula_ConvertData(textBoxValue.toString(), 2,5);\r\n");
	js.append("						var cell=editRow.cells[cellIndex];\r\n");
	js.append("						WebGrid_setInnerText(cell,floatAll);\r\n");
	js.append("					}\r\n");
	js.append("					ListManager_Set(editRow.rowIndex,textBoxValue,hidden);\r\n");
	js.append("					continue;\r\n");
	js.append("				}\r\n");
	js.append("				var func=textObj.getAttribute(\"setValue\");				\r\n");
	js.append("				eval(func+\"('\"+textObj.id+\"',\"+textBoxValue+\")\");				\r\n");
	js.append("				ListManager_Set(editRow.rowIndex,textBoxValue,hidden);\r\n");
	js.append("			}\r\n");
	js.append("		}\r\n");
	js.append("	}\r\n");
	js.append("	\r\n");
	js.append("	function Formula_Convertformat(objText,value)\r\n");
	js.append("	{\r\n");
	js.append("		var listSeparator=objText.getAttribute(\"listSeparator\");\r\n");
	js.append("		if(listSeparator==null)\r\n");
	js.append("		{\r\n");
	js.append("			listSeparator=\"\";\r\n");
	js.append("		}\r\n");
	js.append("		if (value!=\"\")\r\n");
	js.append("		{\r\n");
	js.append("			var m = value;\r\n");
	js.append("			var prefix = \"\";\r\n");
	js.append("			if (m.indexOf(\"-\") == 0)\r\n");
	js.append("			{\r\n");
	js.append("				prefix = \"-\";\r\n");
	js.append("				m = m.substring(1);\r\n");
	js.append("			}\r\n");
	js.append("			var result = \"\";\r\n");
	js.append("			result = m;\r\n");
	js.append("			var f = \"\";\r\n");
	js.append("			var l = \"\";\r\n");
	js.append("			if (result.indexOf(\".\", 0) != -1)\r\n");
	js.append("			{\r\n");
	js.append("				f = result.substring(0, result.indexOf(\".\"));\r\n");
	js.append("				l = result.substring(result.indexOf(\".\") + 1);\r\n");
	js.append("			}\r\n");
	js.append("			else\r\n");
	js.append("			{\r\n");
	js.append("				f = result;\r\n");
	js.append("			}\r\n");
	js.append("			var length = f.length - 1;\r\n");
	js.append("			for (var i = length - 3; i >= 0; i = i - 3)\r\n");
	js.append("			{\r\n");
	js.append("				f = f.substring(0, i + 1) + listSeparator + f.substring(i + 1);\r\n");
	js.append("			}\r\n");
	js.append("			if (l == \"\")\r\n");
	js.append("			{\r\n");
	js.append("				return  prefix + f;\r\n");
	js.append("\r\n");
	js.append("			}\r\n");
	js.append("			else\r\n");
	js.append("			{\r\n");
	js.append("				return prefix + f + \".\" + l;\r\n");
	js.append("\r\n");
	js.append("			}\r\n");
	js.append("		}\r\n");
	js.append("	}\r\n");
	js.append("	function Formula_ConvertData(value,DecimalDigits,SignNum) {\r\n");
	js.append("	  value = value.replace(/,/g,\"\");\r\n");
	js.append("	 if (value==\"\") \r\n");
	js.append("	 {\r\n");
	js.append("			return \"0\";\r\n");
	js.append("	}\r\n");
	js.append("   \r\n");
	js.append("        var prefix = \"\";\r\n");
	js.append("        var s = value;\r\n");
	js.append("        if (s.indexOf(\"-\") == 0) {\r\n");
	js.append("            prefix = \"-\";\r\n");
	js.append("            s = s.substring(1);\r\n");
	js.append("        }\r\n");
	js.append("        if (s.indexOf(\"0\") == 0) {\r\n");
	js.append("            s = TrimNum(s)\r\n");
	js.append("        }\r\n");
	js.append("        var f = \"\";\r\n");
	js.append("        var l = \"\";\r\n");
	js.append("        if (s.indexOf(\".\") != -1) {\r\n");
	js.append("            f = s.substring(0, s.indexOf(\".\"));\r\n");
	js.append("            l = s.substring(s.indexOf(\".\") + 1);\r\n");
	js.append("        }\r\n");
	js.append("        else {\r\n");
	js.append("            f = s;\r\n");
	js.append("        }\r\n");
	js.append("        var result;\r\n");
	js.append("        var theNum = 0;\r\n");
	js.append("        if (DecimalDigits == -1) {\r\n");
	js.append("            if (l.length > 0) {\r\n");
	js.append("                result = f + \".\" + l;\r\n");
	js.append("            }\r\n");
	js.append("            else {\r\n");
	js.append("                result = f;\r\n");
	js.append("            }\r\n");
	js.append("        }\r\n");
	js.append("        else if (DecimalDigits == 0) {\r\n");
	js.append("            var lastNum = \"0\";\r\n");
	js.append("            if (l.length > 0) {\r\n");
	js.append("                lastNum = l.substring(DecimalDigits, DecimalDigits*1 + 1);\r\n");
	js.append("            }\r\n");
	js.append("            if (parseInt(lastNum, 0) >= SignNum && SignNum != -1) {\r\n");
	js.append("                theNum++;\r\n");
	js.append("            }\r\n");
	js.append("            if (theNum > 0) {\r\n");
	js.append("                result = (parseInt(f, 0) + 1) + \"\";\r\n");
	js.append("            }\r\n");
	js.append("            else {\r\n");
	js.append("                result = f;\r\n");
	js.append("            }\r\n");
	js.append("        }\r\n");
	js.append("        else {\r\n");
	js.append("            if (l.length > 0) {\r\n");
	js.append("                var lastNum = \"0\";\r\n");
	js.append("                if (l.length > DecimalDigits) {\r\n");
	js.append("                    lastNum = l.substring(DecimalDigits, DecimalDigits*1 + 1);\r\n");
	js.append("                    l = l.substring(0, DecimalDigits);\r\n");
	js.append("                }\r\n");
	js.append("                else{\r\n");
	js.append("                    for (var i = l.length; i < DecimalDigits; i++) {\r\n");
	js.append("                        l = l + \"0\";\r\n");
	js.append("                    }\r\n");
	js.append("                }\r\n");
	js.append("                if (parseInt(lastNum, 0) >= SignNum) {\r\n");
	js.append("                    theNum++;\r\n");
	js.append("                }\r\n");
	js.append("                increscent = Math.pow(10, DecimalDigits);\r\n");
	js.append("                increscentL = parseInt(1 + \"\" + l) + theNum;\r\n");
	js.append("                var toInt = parseInt( (increscentL - increscent) +\"\")\r\n");
	js.append("                if (toInt < increscent) {\r\n");
	js.append("                    toInt = 0\r\n");
	js.append("                }\r\n");
	js.append("                else {\r\n");
	js.append("                    toInt = 1\r\n");
	js.append("                }\r\n");
	js.append("                if(f==\"\"){f=\"0\";}\r\n");
	js.append("                result = parseInt(f, 0) + toInt + \".\" +(increscentL + \"\").substring(1);\r\n");
	js.append("            }\r\n");
	js.append("            else {\r\n");
	js.append("                for (var i = 0; i < DecimalDigits; i++) {\r\n");
	js.append("                    l = l + \"0\";\r\n");
	js.append("                }\r\n");
	js.append("                if(f==\"\"){f=\"0\";}\r\n");
	js.append("                result = f + \".\" + l;\r\n");
	js.append("            }\r\n");
	js.append("        }\r\n");
	js.append("        return prefix + result;\r\n");
	js.append("}");


     return jstool.getComponentJS() + HashMapJS.getHashMapJS();
  }
}