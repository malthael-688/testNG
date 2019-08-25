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
public class Select implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> methodInstances, ITestContext context) {


        for (IMethodInstance methodInstance : methodInstances) {
            ITestNGMethod method = methodInstance.getMethod();
            if (method.getMethodName().equals("register")){
                Connection c = null;
                Statement s = null;
                try{
                    c = Connect.getInstance().getConnection();
                    s = c.createStatement();

                    String str = "delete from User where account = 1041405881";
                    s.executeQuery(str);
                }catch (Exception e){
                    System.out.println("clean environment error");
                }
            }
        }

        return methodInstances;
    }
}
