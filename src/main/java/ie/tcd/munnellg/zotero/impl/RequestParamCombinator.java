package ie.tcd.munnellg.zotero.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import ie.tcd.munnellg.zotero.interfaces.RequestParams;

public class RequestParamCombinator implements RequestParams
{
	List<RequestParams> requestParams;

	public RequestParamCombinator()
	{
		this(RequestParamCombinator.builder());
	}

	private RequestParamCombinator(RequestParamCombinatorBuilder builder)
	{
		this.requestParams = builder.requestParams;
	}

	public List<RequestParams> getRequestParams()
	{
		return this.requestParams;
	}

	public void setRequestParams(List<RequestParams> requestParams)
	{
		this.requestParams = requestParams;
	}

	public void addRequestParam(RequestParams requestParams)
	{
		this.requestParams.add(requestParams);
	}

	@Override
	public List<String> paramsToQueryString()
	{
		Stream<String> params = Stream.empty();

		for (RequestParams rp : this.requestParams)
		{
			params = Stream.concat(params, rp.paramsToQueryString().stream());
		}

		return params.collect(Collectors.toList());
	}

	public static RequestParamCombinatorBuilder builder()
	{
		return new RequestParamCombinatorBuilder();
	}

	public static class RequestParamCombinatorBuilder
	{
		private List<RequestParams> requestParams;

		public RequestParamCombinatorBuilder()
		{
			this.requestParams = new ArrayList<RequestParams>();
		}

		public RequestParamCombinatorBuilder setItemKey(List<RequestParams> requestParams)
		{
			this.requestParams = requestParams;
			return this;
		}

		public RequestParamCombinatorBuilder addRequestParam(RequestParams requestParams)
		{
			this.requestParams.add(requestParams);
			return this;
		}

		public RequestParamCombinator build()
		{
			return new RequestParamCombinator(this);
		}
	}
}