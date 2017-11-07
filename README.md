# 1.项目内容：

 - baseadapter：RecyclerAdapterClick/ExpandableRecyclerViewAdapter
 - decoration：三种基础RecyclerVioew布局的 万能边线 
 - view:RadioGroupFlowLayout RadioGroup单选布局的 增强类
   
# 2.项目导入  

    build.gradle  
		allprojects {
    		repositories {
    			...
    			maven { url 'https://jitpack.io' }
    		}
    	}  
        dependencies {
            compile 'com.github.Daimhim.usedlibrary:used:1.0.5-alpha-3'
        }
	
	
