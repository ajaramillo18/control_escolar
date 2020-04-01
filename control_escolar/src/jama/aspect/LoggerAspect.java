/**
 * 
 */
package jama.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ajara
 *
 */
@Component
@Aspect
public class LoggerAspect {
	
	@Before("within(jama.controller.*)")// to execute for all methods of all classes of service package
	public void logBeginController(JoinPoint joinPoint)
	{
		System.out.println("preparando lienzo");
		System.out.println(joinPoint.toString());
		System.out.println(joinPoint.getTarget());
		
	}

	
	@AfterThrowing(pointcut = "within(jama.controller.*)", throwing = "ex")//this will be executed after an exeption is thrown
	public void logErrorController(JoinPoint joinPoint, Exception ex)
	{
		System.out.println("transaction rolled back");
		System.out.println("joinpoint: " + joinPoint.toString());
		System.out.println("exception thrown: " + ex.getMessage());
		
	}
	
	
	@AfterReturning(pointcut = "within(jama.controller.*)", returning = "objectReturned")//this will be executed  only after the methods returns (as in there are no exceptions)
	public void logSuccessController(JoinPoint joinPoint, Object objectReturned)
	{
		System.out.println("transaction comitted");
		System.out.println("joinpoint: " + joinPoint.toString());
		System.out.println("object returned: " + objectReturned.toString());
		
	}

}
