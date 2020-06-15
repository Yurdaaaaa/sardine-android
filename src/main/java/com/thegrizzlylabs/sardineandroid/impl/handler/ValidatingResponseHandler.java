package com.thegrizzlylabs.sardineandroid.impl.handler;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;

import okhttp3.Response;

/**
 * Created by guillaume on 20/11/2017.
 */

public abstract class ValidatingResponseHandler<T> implements ResponseHandler<T>
{
    /**
     * Checks the response for a statuscode between 200 and 300
     * and throws an {@link SardineException} otherwise.
     *
     * @param response to check
     * @throws SardineException when the status code is not acceptable.
     */
    protected void validateResponse(Response response) throws SardineException {
        if (!response.isSuccessful()) {
            String message = "Error contacting " + response.request().url();
            int code = response.code();
            String responseMsg = response.message();
            response.close();
            throw new SardineException(message, code , responseMsg);
        }
    }
}
