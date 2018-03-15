package br.net.gvt.efika.customerAPI.model;

import br.net.gvt.efika.customer.model.dto.GenericRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Date;

public class CertificationResponse {

    private Long id = null;
    private GenericRequest request = null;
    private Date responseDate = null;

    /**
     *
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     */
    @JsonProperty("request")
    public GenericRequest getRequest() {
        return request;
    }

    public void setRequest(GenericRequest request) {
        this.request = request;
    }

    /**
     * Data da Resposta
   *
     */
    @JsonProperty("responseDate")
    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CertificationResponse certificationResponse = (CertificationResponse) o;
        return Objects.equals(id, certificationResponse.id)
                && Objects.equals(request, certificationResponse.request)
                && Objects.equals(responseDate, certificationResponse.responseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, responseDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CertificationResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    request: ").append(toIndentedString(request)).append("\n");
        sb.append("    responseDate: ").append(toIndentedString(responseDate)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
