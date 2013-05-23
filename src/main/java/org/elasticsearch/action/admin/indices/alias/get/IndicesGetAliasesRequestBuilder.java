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

package org.elasticsearch.action.admin.indices.alias.get;

import com.google.common.collect.ObjectArrays;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.support.master.MasterNodeOperationRequestBuilder;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.internal.InternalIndicesAdminClient;

/**
 */
public class IndicesGetAliasesRequestBuilder extends MasterNodeOperationRequestBuilder<IndicesGetAliasesRequest, IndicesGetAliasesResponse, IndicesGetAliasesRequestBuilder> {

    public IndicesGetAliasesRequestBuilder(IndicesAdminClient client, String... aliases) {
        super((InternalIndicesAdminClient)client, new IndicesGetAliasesRequest(aliases));
    }

    public IndicesGetAliasesRequestBuilder setAliases(String... aliases) {
        request.aliases(aliases);
        return this;
    }

    public IndicesGetAliasesRequestBuilder addAliases(String... aliases) {
        request.aliases(ObjectArrays.concat(request.aliases(), aliases, String.class));
        return this;
    }

    public IndicesGetAliasesRequestBuilder setIndices(String... indices) {
        request.indices(indices);
        return this;
    }

    public IndicesGetAliasesRequestBuilder addIndices(String... indices) {
        request.indices(ObjectArrays.concat(request.indices(), indices, String.class));
        return this;
    }

    @Override
    protected void doExecute(ActionListener<IndicesGetAliasesResponse> listener) {
        ((IndicesAdminClient) client).getAliases(request, listener);
    }

}