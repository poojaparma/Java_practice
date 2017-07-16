package com.oauth.utility;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

import org.springframework.boot.actuate.health.DiskSpaceHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {
	DiskSpaceHealthIndicator d;

	public Health health() {
		List<MemoryPoolMXBean> memPool = ManagementFactory.getMemoryPoolMXBeans();
		for (MemoryPoolMXBean pool : memPool) {
			if("Metaspace".equalsIgnoreCase(pool.getName()))
			System.out.println("collection usage  {}" + pool.getCollectionUsage() 
					+ "obj " + pool.getObjectName() + "  peek " + pool.getPeakUsage()  + "  usage "
					+ pool.getUsage());
			for(String s:  pool.getMemoryManagerNames()){
				System.out.println("managerNames: " +s);
				
			}
		}
		System.out.println("healyh check clled");
		int errorCode = 0;
		if (errorCode != 1) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}

}