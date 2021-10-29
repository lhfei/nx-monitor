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

package cn.lhfei.monitor.orm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.lhfei.monitor.orm.domain.ModuleEntity;
import cn.lhfei.monitor.orm.domain.StatisticsEntity;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @created on Oct 11, 2019
 */
@Mapper
public interface ModuleMapper extends AbstractMapper<ModuleEntity, Long> {

	List<ModuleEntity> getSystems(ModuleEntity moduleEntity);

	List<ModuleEntity> getModules(ModuleEntity moduleEntity);

	List<StatisticsEntity> getStatistics(ModuleEntity moduleEntity);

	List<StatisticsEntity> getWords(ModuleEntity moduleEntity);
}
