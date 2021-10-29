/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.lhfei.monitor.conveter;

import java.util.Date;

import com.alibaba.otter.canal.protocol.FlatMessage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cn.lhfei.monitor.orm.domain.OpsLog;
import cn.lhfei.monitor.orm.domain.OpsSeries;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * Created on Oct 09, 2019
 */
public class KafkaMessageConvert {
	private static Gson gson = new Gson();
	
	public static ThreadLocal<OpsLog> opsLogThreadLocal = new ThreadLocal<OpsLog>() {
		@Override
		protected OpsLog initialValue() {
			OpsLog log = new OpsLog();
			log.setInstanceIp("10.216.217.28");
			log.setServerId(30071);
			log.setDbName("kafka_conn");
			
			return log;
		}
	};
	public static ThreadLocal<OpsSeries> opsSeriesThreadLocal = new ThreadLocal<OpsSeries>() {
		@Override
		protected OpsSeries initialValue() {
			OpsSeries log = new OpsSeries();
			log.setInstanceIp("10.216.217.28");
			log.setServerId(30071);
			log.setDbName("kafka_conn");
			
			return log;
		}
	};

	public static OpsLog convert(String message) {
		OpsLog log = opsLogThreadLocal.get();
		
//		JsonObject object = gson.fromJson(message, JsonObject.class);
		
		FlatMessage msg = gson.fromJson(message, FlatMessage.class);
		log.setTableName(msg.getTable());
		log.setType(msg.getType());
		log.setOpsTs(msg.getTs());
//		log.setEffectSize(msg.getData().size());
//		log.setOpsTime(new Date(msg.getTs()));
		
		return log;
	}
	
}
