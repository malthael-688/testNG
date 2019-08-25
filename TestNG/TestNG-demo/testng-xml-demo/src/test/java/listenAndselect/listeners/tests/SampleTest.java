package listenAndselect.listeners.tests;

import listenAndselect.listeners.OSFilter;
import listenAndselect.listeners.OSNames;
import listenAndselect.listeners.ProgressTracker;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ OSFilter.class, ProgressTracker.class })
public class SampleTest {

	@Test(groups = { OSNames.OS_LINUX })
	public void test1() {
		sleep(5000);
		System.out.println(">>>test1");
	}

	@Test(groups = { OSNames.OS_LINUX, OSNames.OS_WINDOWS })
	public void test2() {
		sleep(3000);
		System.out.println(">>>test2");
	}

	@Test(groups = { OSNames.OS_LINUX, OSNames.OS_WINDOWS })
	public void test3() {
		sleep(2000);
		System.out.println(">>>test3");
	}

	@Test(groups = { OSNames.OS_WINDOWS })
	public void test4() {
		sleep(5000);
		System.out.println(">>>test4");
	}

	@Test(groups = { OSNames.OS_WINDOWS })
	public void test5() {
		sleep(5000);
		System.out.println(">>>test5");
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
