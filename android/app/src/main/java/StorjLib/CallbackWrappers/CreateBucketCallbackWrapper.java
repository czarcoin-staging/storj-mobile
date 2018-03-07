package storjlib.CallbackWrappers;

import com.facebook.react.bridge.Promise;

import storjlib.Models.BucketModel;
import storjlib.Responses.Response;
import storjlib.Responses.SingleResponse;
import io.storj.libstorj.Bucket;
import io.storj.libstorj.CreateBucketCallback;

/**
 * Created by Yaroslav-Note on 1/24/2018.
 */

public class CreateBucketCallbackWrapper extends BaseCallbackWrapper<BucketModel> implements CreateBucketCallback {

    public CreateBucketCallbackWrapper(Promise promise) {
        super(promise);
    }

    @Override
    public void onBucketCreated(Bucket bucket) {
        _promise.resolve(new SingleResponse(true, toJson(new BucketModel(bucket)), null).toWritableMap());
    }

    @Override
    public void onError(int code, String message) {
        //TODO: create error model to pass both message and error code
        _promise.resolve(new Response(false, message, code).toWritableMap());
    }
}
