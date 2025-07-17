package models.users;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GetUsersResponse{
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	private List<DataItem> data;
	private int page;
	@JsonProperty("total_pages")
	private int totalPages;
	private Support support;

	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	public int getPerPage(){
		return perPage;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setSupport(Support support){
		this.support = support;
	}

	public Support getSupport(){
		return support;
	}
}