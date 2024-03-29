package com.dcits.listeners;

import com.dcits.dataprovider.Connect;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * public interface IMethodInterceptor extends ITestNGListener {
 *     List<IMethodInstance> intercept(List<IMethodInstance> var1, ITestContext var2);
 * }
 */
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class Select implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> methodInstances, ITestContext context) {


        for (IMethodInstance methodInstance : methodInstances) {
            ITestNGMethod method = methodInstance.getMethod();

            if (method.getMethodName().equals("register")){
                System.out.println(method.getMethodName());
                Connection c = null;
                Statement s = null;
                try{
                    c = Connect.getInstance().getConnection();
                    s = c.createStatement();
                    String str = "show variables like \"sql_mode\";";
                    s.execute(str);
                    str = "set sql_mode='';";
                    s.execute(str);
                    str = "set sql_mode='NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES';\n";
                    s.execute(str);
                    str = "delete from User where account = 1041405881";
                    s.execute(str);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("clean environment error");
                }
            }
        }

        return methodInstances;
    }
}
