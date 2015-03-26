//JS Map
function Map() {
	this.container = new Object();
}

Map.prototype.put = function(key, value) {
	this.container[key] = value;
}

Map.prototype.get = function(key) {
	return this.container[key];
}

Map.prototype.keySet = function() {
	var keyset = new Array();
	var count = 0;
	for ( var key in this.container) {
		// 跳过object的extend函数
		if (key == 'extend') {
			continue;
		}
		keyset[count] = key;
		count++;
	}
	return keyset;
}

Map.prototype.size = function() {
	var count = 0;
	for ( var key in this.container) {
		// 跳过object的extend函数
		if (key == 'extend') {
			continue;
		}
		count++;
	}
	return count;
}

Map.prototype.remove = function(key) {
	delete this.container[key];
}

Map.prototype.toString = function() {
	var str = "";
	for ( var i = 0, keys = this.keySet(), len = keys.length; i < len; i++) {
		str = str + keys[i] + "=" + this.container[keys[i]] + ";\n";
	}
	return str;
}

//IE8下面 数组没有indexOf方法  添加下面代码，如果数组没有indexOf方法 添加
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
    var len = this.length >>> 0;

    var from = Number(arguments[1]) || 0;
    from = (from < 0)
         ? Math.ceil(from)
         : Math.floor(from);
    if (from < 0)
      from += len;

    for (; from < len; from++)
    {
      if (from in this &&
          this[from] === elt)
        return from;
    }
    return -1;
  };
}

//对日期数组去重
function sortArray(strArray){
	var n = []; //一个新的临时数组
	for(var i = 0; i < strArray.length; i++) //遍历当前数组
	{
		//如果当前数组的第i已经保存进了临时数组，那么跳过，
		//否则把当前项push到临时数组里面
		if (n.indexOf(strArray[i]) == -1) 
			n.push(strArray[i]);
	}
	return n;
}

//统计母字符串中子字符串出现的次数
function getCount(str1,str2){
	  var r=new RegExp(str2,"gi");
	  if(str1 == ""){
		  return 0;
	  }else{
		  return str1.match(r).length;
	  }
} 

//去除字符串左右空格
function trim(str){   
    str = str.replace(/^(\s|\u00A0)+/,'');   
    for(var i=str.length-1; i>=0; i--){   
        if(/\S/.test(str.charAt(i))){   
            str = str.substring(0, i+1);   
            break;   
        }   
    }   
    return str;   
}  

String.prototype.trim = function()  
{  
   return this.replace(/(^\s*)|(\s*$)/g, "");  
}  


//添加JS的StringBuffer类
function strBuild(){
	stringBuild = function() {
		var arr = new Array();

		this.append = appendfun;
		this.join = joinfun;
		this.toString = joinfun;
		function appendfun(string) {
			arr.push(string);
		}
		function joinfun() {
			if (arr.length == 0)
				return "";
			return arr.join("");
		}
	}

	String.prototype.format = function(args) {
		var result = this;
		if (arguments.length > 0) {
			if (arguments.length == 1 && typeof (args) == "object") {
				for ( var key in args) {
					if (args[key] != undefined) {
						var reg = new RegExp("({" + key + "})", "g");
						result = result.replace(reg, args[key]);
					}
				}
			} else {
				for ( var i = 0; i < arguments.length; i++) {
					if (arguments[i] != undefined) {
						var reg = new RegExp("\\{" + i + "\\}", "g");
						result = result.replace(reg, arguments[i]);
					}
				}
			}
		}
		return result;
	}
}

//jS分页
function goPage(pno,psize,tableID,url,dataSize,type){
	var barconID="";
	if(typeof(type)!='undefined'){
		barconID=type;
	}
	var itable = document.getElementById(tableID);
	var num = itable.rows.length;//表格行数
	var totalPage = 0;//总页数
	var pageSize = psize;//每页显示行数
	if(dataSize/pageSize > parseInt(dataSize/pageSize)){   
 		totalPage=parseInt(dataSize/pageSize)+1;   
 	}else{   
 		totalPage=parseInt(dataSize/pageSize);   
 	}   
	var currentPage = parseInt(pno);//当前页数
	/*
	var startRow = (currentPage - 1) * pageSize+1;//开始显示的行   
 	var endRow = currentPage * pageSize+1;//结束显示的行   
 	endRow = (endRow > num)? num : endRow;
	//前三行始终显示
	for(i=0;i<1;i++){
		var irow = itable.rows[i];
		irow.style.display = "";
	}
	for(var i=1;i<num;i++){
		var irow = itable.rows[i];
		if(i>=startRow&&i<endRow){
			irow.style.display = "";	
		}else{
			irow.style.display = "none";
		}
	}
	*/
	//var tempStr = "共"+(num-1)+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
	var tempStr = "<tr><td><input type='hidden' id='pageSize' name='pageSize' value="+currentPage+"/><table  width='98%' border='0' align='right'>"+
				  "<tr><td><table align='right' border='0'><tr>";
	
	if(currentPage>1){
		tempStr += "<td width='26' ><a style='cursor: pointer;' onClick=\"page("+(currentPage-1)+","+type+")\"><img src='"+url+"/images/z.jpg' width='27' height='25' border='0' /></a></td>";
	}else{
		tempStr += "<td width='26' ><a style='cursor: pointer;'><img src='"+url+"/images/z.jpg' width='27' height='25' border='0'/></a></td>";
	}
	
	if(totalPage<=10){
		for(var i=1;i<=totalPage;i++){
			if(currentPage==i){
				tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
			}else{
				tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
			}
		}
	}else{
		if(currentPage<=5){
			for(var i=1;i<=10;i++){
				if(currentPage==i){
					tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
				}else{
					tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
				}
			}
		}else{
			if(totalPage>currentPage+5){
				for(var i=currentPage-4;i<=currentPage+5;i++){
					if(currentPage==i){
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}else{
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}
				}
			}else{
				for(var i=totalPage-9;i<=totalPage;i++){
					if(currentPage==i){
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}else{
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}
				}
			}
		}
		
	}
	
	if(totalPage>currentPage){
		var size = currentPage+1;
		tempStr += "<td width='20' ><a style='cursor: pointer;' onClick=\"page("+size+","+type+")\"><img src='"+url+"/images/y.jpg' width='27' height='25' border='0' /></a></td>"
	}else{
		tempStr += "<td width='20' ><a style='cursor: pointer;' ><img src='"+url+"/images/y.jpg' width='27' height='25' border='0' /></a></td>"
	}
	var idname="topage"+type;
	tempStr += "<th>共"+totalPage+"页到<input  style='width:30px' id='"+idname+"' name ='"+idname+"' value=''  " +
			"onkeyup= 'yanzheng(this.value,type)'><button type='button' class='button gray' style='cursor: pointer;' onclick=\"topage("+pageNum+","+totalPage+","+psize+","+"'"+tableID+"',"+"'"+url+"',"+"'"+type+"')\">跳转</button></th>";
	tempStr += "</tr></table></td></tr></table></td></tr>";
	document.getElementById("barcon"+barconID).innerHTML = tempStr;
}

//jS小分页
function goPage1(pno,psize,tableID,url,dataSize,type){
	var barconID="";
	if(typeof(type)!='undefined'){
		barconID=type;
	}
	var itable = document.getElementById(tableID);
	var num = itable.rows.length;//表格行数
	var totalPage = 0;//总页数
	var pageSize = psize;//每页显示行数
	if(dataSize/pageSize > parseInt(dataSize/pageSize)){   
 		totalPage=parseInt(dataSize/pageSize)+1;   
 	}else{   
 		totalPage=parseInt(dataSize/pageSize);   
 	}   
	var currentPage = parseInt(pno);//当前页数
	/*
	var startRow = (currentPage - 1) * pageSize+1;//开始显示的行   
 	var endRow = currentPage * pageSize+1;//结束显示的行   
 	endRow = (endRow > num)? num : endRow;
	//前三行始终显示
	for(i=0;i<1;i++){
		var irow = itable.rows[i];
		irow.style.display = "";
	}
	for(var i=1;i<num;i++){
		var irow = itable.rows[i];
		if(i>=startRow&&i<endRow){
			irow.style.display = "";	
		}else{
			irow.style.display = "none";
		}
	}
	*/
	//var tempStr = "共"+(num-1)+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
	var tempStr = "<tr><td><input type='hidden' id='pageSize' name='pageSize' value="+currentPage+"/><table  width='98%' border='0' align='right'>"+
				  "<tr><td><table align='right' border='0'><tr>";
	
	if(currentPage>1){
		tempStr += "<td width='26' ><a style='cursor: pointer;' onClick=\"page("+(currentPage-1)+","+type+")\"><img src='"+url+"/images/z.jpg' width='27' height='25' border='0' /></a></td>";
	}else{
		tempStr += "<td width='26' ><a style='cursor: pointer;'><img src='"+url+"/images/z.jpg' width='27' height='25' border='0'/></a></td>";
	}
	
	if(totalPage<=3){
		for(var i=1;i<=totalPage;i++){
			if(currentPage==i){
				tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
			}else{
				tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
			}
		}
	}else{
		if(currentPage<=1){
			for(var i=1;i<=3;i++){
				if(currentPage==i){
					tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
				}else{
					tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>";
				}
			}
		}else{
			if(totalPage>currentPage+1){
				for(var i=currentPage-1;i<=currentPage+1;i++){
					if(currentPage==i){
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}else{
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}
				}
			}else{
				for(var i=totalPage-2;i<=totalPage;i++){
					if(currentPage==i){
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style = 'color:red;cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}else{
						tempStr += "<td width='30px' class='tzbtn' id="+i+"><a style='cursor: pointer;' onClick=\"page("+i+","+type+")\">"+i+"</a></td>"
					}
				}
			}
		}
		
	}
	
	if(totalPage>currentPage){
		var size = currentPage+1;
		tempStr += "<td width='20' ><a style='cursor: pointer;' onClick=\"page("+size+","+type+")\"><img src='"+url+"/images/y.jpg' width='27' height='25' border='0' /></a></td>"
	}else{
		tempStr += "<td width='20' ><a style='cursor: pointer;' ><img src='"+url+"/images/y.jpg' width='27' height='25' border='0' /></a></td>"
	}
	var idname="topage"+type;
	tempStr += "<th>共"+totalPage+"页到<input  style='width:30px' id='"+idname+"' name ='"+idname+"' value=''  " +
			"onkeyup= 'yanzheng(this.value,type)'><button type='button' class='button gray' style='cursor: pointer;' onclick=\"topage("+pageNum+","+totalPage+","+psize+","+"'"+tableID+"',"+"'"+url+"',"+"'"+type+"')\">跳转</button></th>";
	tempStr += "</tr></table></td></tr></table></td></tr>";
	document.getElementById("barcon"+barconID).innerHTML = tempStr;
}

var pageNum = 1;
function yanzheng(value,type){
	value=value.replace(/\D/g,"");
	$("#topage"+type).val(value);
	pageNum = value;
}

function topage(pageNum,totalPage,pageSize,tableId,url,type){
	if($("#topage"+type).val()==""){
		return false;
	}
	if($("#topage"+type).val()>totalPage){
		//goPage(totalPage,pageSize,tableId,url);
		page(totalPage,parseInt(type));
	}else if(Number($("#topage"+type).val())<1){
		//goPage(1,pageSize,tableId,url);
		page(1,parseInt(type));
	}else{
		//goPage(Number($("#topage").val()),pageSize,tableId,url);
		page(Number($("#topage"+type).val()),parseInt(type));
	}
	
}

//可拖动div
var rDrag = {
		o:null,
		
		init:function(o){
			o.onmousedown = this.start;
		},
		start:function(e){
			var o;
			e = rDrag.fixEvent(e);
	               e.preventDefault && e.preventDefault();
	               rDrag.o = o = this;
			o.x = e.clientX - rDrag.o.offsetLeft;
	                o.y = e.clientY - rDrag.o.offsetTop;
			document.onmousemove = rDrag.move;
			document.onmouseup = rDrag.end;
		},
		move:function(e){
			e = rDrag.fixEvent(e);
			var oLeft,oTop;
			oLeft = e.clientX - rDrag.o.x;
			oTop = e.clientY - rDrag.o.y;
			rDrag.o.style.left = oLeft + 'px';
			rDrag.o.style.top = oTop + 'px';
		},
		end:function(e){
			e = rDrag.fixEvent(e);
			rDrag.o = document.onmousemove = document.onmouseup = null;
		},
	    fixEvent: function(e){
	        if (!e) {
	            e = window.event;
	            e.target = e.srcElement;
	            e.layerX = e.offsetX;
	            e.layerY = e.offsetY;
	        }
	        return e;
	    }
	}

Date.prototype.format = function(format)
{
var o = {
            "M+" : this.getMonth()+1, //month
            "d+" : this.getDate(), //day
            "h+" : this.getHours(), //hour
            "m+" : this.getMinutes(), //minute
            "s+" : this.getSeconds(), //second
            "q+" : Math.floor((this.getMonth()+3)/3), //quarter
            "S" : this.getMilliseconds() //millisecond
        }
    if(/(y+)/.test(format))
    format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
    if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}
//div拖动
function moveDiv(event, id){   

    var offset=$("#" + id).offset();   

    x1=event.clientX-offset.left;   

    y1=event.clientY-offset.top;   

    $("#" + id).mousemove(function(event){   

       $("#" + id).css("left",(event.clientX-x1)+"px");   

        $("#" + id).css("top",(event.clientY-y1)+"px");   

    });   

    $("#" + id).mouseup(function(event){   

        $("#" + id).unbind("mousemove");   

    });
}
