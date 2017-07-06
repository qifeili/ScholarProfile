/**
 * 
 */
package cn.scholarprofile.aspect;

/*import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;*/
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年4月11日 下午10:05:31
 * @Description :
 * @version 1.0
 */
@Component
@Aspect
//@Order(value = 2)
public class LoggingAspect {

	
	private final static Log log = LogFactory.getLog(LoggingAspect.class);

	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	public void aspect() {
	}

	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点 同时接受JoinPoint切入点对象,可以没有该参数
	 */
	@Before("execution(* cn.scholarprofile.service..*.*(..))")
	public void before(JoinPoint joinPoint) {
		if (log.isInfoEnabled()) {
			log.info("before " + joinPoint);
		}
	}

	// 配置后置通知,使用在方法aspect()上注册的切入点
	@After("execution(* cn.scholarprofile.service..*.*(..))")
	public void after(JoinPoint joinPoint) {
		if (log.isInfoEnabled()) {
			log.info("after " + joinPoint);
		}
	}

	// 配置环绕通知,使用在方法aspect()上注册的切入点
	@Around("execution(* cn.scholarprofile.service..*.*(..))")
	//@Around("execution(* cn.scholarprofile..*.*(..))")//换成这个会数据丢失
	public Object around(ProceedingJoinPoint joinPoint) {
		long start = System.currentTimeMillis();
		Object retVal = null;
		try {
			retVal = joinPoint.proceed();
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
			}
			return retVal;
			
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			if (log.isInfoEnabled()) {
				log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
						+ e.getMessage());
			}
			return retVal;
		}
	}

	// 配置后置返回通知,使用在方法aspect()上注册的切入点
	@AfterReturning("execution(* cn.scholarprofile.service..*.*(..))")
	public void afterReturn(JoinPoint joinPoint) {
		if (log.isInfoEnabled()) {
			log.info("afterReturn " + joinPoint);
		}
	}

	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut = "execution(* cn.scholarprofile.service..*.*(..))", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		if (log.isInfoEnabled()) {
			log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
		}
	}
	
	/*
	 * @Around("execution(* cn.scholarprofile.service..*.*(..))") public Object
	 * logMethod(ProceedingJoinPoint joinPoint) throws Throwable{ final Logger
	 * logger =
	 * LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
	 * Object retVal = null;
	 * 
	 * try { StringBuffer startMessageStringBuffer = new StringBuffer();
	 * 
	 * startMessageStringBuffer.append("Start method ");
	 * startMessageStringBuffer.append(joinPoint.getSignature().getName());
	 * startMessageStringBuffer.append("(");
	 * 
	 * Object[] args = joinPoint.getArgs(); for (int i = 0; i < args.length;
	 * i++) { startMessageStringBuffer.append(args[i]).append(","); } if
	 * (args.length > 0) {
	 * startMessageStringBuffer.deleteCharAt(startMessageStringBuffer.length() -
	 * 1); }
	 * 
	 * startMessageStringBuffer.append(")");
	 * 
	 * logger.trace(startMessageStringBuffer.toString());
	 * 
	 * StopWatch stopWatch = new StopWatch(); stopWatch.start();
	 * 
	 * retVal = joinPoint.proceed();
	 * 
	 * stopWatch.stop();
	 * 
	 * StringBuffer endMessageStringBuffer = new StringBuffer();
	 * endMessageStringBuffer.append("Finish method ");
	 * endMessageStringBuffer.append(joinPoint.getSignature().getName());
	 * endMessageStringBuffer.append("(..); execution time: ");
	 * endMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
	 * endMessageStringBuffer.append(" ms;");
	 * 
	 * logger.trace(endMessageStringBuffer.toString()); } catch (Throwable ex) {
	 * StringBuffer errorMessageStringBuffer = new StringBuffer();
	 * 
	 * // Create error message logger.error(errorMessageStringBuffer.toString(),
	 * ex);
	 * 
	 * throw ex; }
	 * 
	 * return retVal; }
	 */
}
