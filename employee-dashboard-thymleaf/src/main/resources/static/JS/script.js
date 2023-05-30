function changeValue()
{
	var sb=document.getElementById("dept");
	var dept=document.getElementById("deptc").value;
	for(let i=0;i<sb.options.length;i++)
	{
		if(dept==sb.options[i].value)
		{
			sb.options[i].selected="selected";
			break;
		}
	}
}