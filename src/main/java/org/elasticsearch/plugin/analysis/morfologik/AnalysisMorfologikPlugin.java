/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.plugin.analysis.morfologik;

import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.pl.MorfologikAnalysisBinderProcessor;
import org.elasticsearch.indices.analysis.pl.MorfologikIndicesAnalysisModule;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;

/**
 *
 */
public class AnalysisMorfologikPlugin extends AbstractPlugin {

    @Override
    public String name() {
        return "analysis-morfologik";
    }

    @Override
    public String description() {
        return "Morfologik (Polish) analysis support";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        return ImmutableList.<Class<? extends Module>>of(MorfologikIndicesAnalysisModule.class);
    }

    public void onModule(AnalysisModule module) {
        module.addProcessor(new MorfologikAnalysisBinderProcessor());
    }
}
