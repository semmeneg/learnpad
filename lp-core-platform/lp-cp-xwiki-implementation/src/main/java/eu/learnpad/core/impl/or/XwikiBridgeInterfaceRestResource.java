/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package eu.learnpad.core.impl.or;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import eu.learnpad.exception.LpRestException;
import eu.learnpad.exception.impl.LpRestExceptionImpl;
import eu.learnpad.or.BridgeInterface;
import eu.learnpad.or.rest.data.Recommendations;
import eu.learnpad.or.rest.data.States;
import eu.learnpad.core.rest.RestResource;

/*
 * The methods inherited form the BridgeInterface in this
 * class should be implemented as a REST invocation
 * toward the BridgeInterface binded at the provided URL
 */
 
public class XwikiBridgeInterfaceRestResource extends RestResource implements BridgeInterface{

	public XwikiBridgeInterfaceRestResource() {
		this("localhost",8080);
	}

	public XwikiBridgeInterfaceRestResource(String coreFacadeHostname,
			int coreFacadeHostPort) {
		// This constructor could change in the future
		this.updateConfiguration(coreFacadeHostname, coreFacadeHostPort);
	}
	
	public void updateConfiguration(String coreFacadeHostname, int coreFacadeHostPort){
// This constructor has to be fixed, since it requires changes on the class
//		eu.learnpad.core.rest.RestResource
		
	}

	@Override
	public void sendResourceNotification(String modelSetId, String resourceId,
			String artifactIds, String action) throws LpRestExceptionImpl {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Recommendations askRecommendation(String modelSetId, String artifactId,
			String userId, String type) throws LpRestExceptionImpl {
		// TODO Auto-generated method stub

		Client client = ClientBuilder.newClient();
        client.register(this);
        
// We should look a way for accessing the annotations with reflection
//        eu.learnpad.or.Bridge.class.getAnnotation(Path.class).value();
        
        String URL = this.REST_URI + "learnpad/or/corefacade/" + modelSetId + "/recommendation";
        
        Recommendations response = client.target(URL).queryParam("artifactid", artifactId).queryParam("userid", userId).queryParam("type", type).request("application/xml").get(Recommendations.class);
        
		return response;
	}

	@Override
	public byte[] simulationNotification(String modelSetId, String modelId,
			String action, String simulationId) throws LpRestExceptionImpl {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExecutionState(String artifactName,
			String artifactDescription, String artifactType, String modelType,
			String freeDescription, String existingArtifactId,
			String existingArtifactStructureDepth) throws LpRestExceptionImpl {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addExecutionState(String modelSetId, String executionId,
			String userId, String threadId, String pageId, String artifactId)
			throws LpRestExceptionImpl {
		// TODO Auto-generated method stub
		
	}

	@Override
	public States listExecutionStates(String userId) throws LpRestExceptionImpl {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modelSetImported(String modelSetId, String type)
			throws LpRestException {
		// TODO Auto-generated method stub
		
	}


}
