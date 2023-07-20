import json
import urllib3
http = urllib3.PoolManager()


def lambda_handler(event, context):
    # get params
    params = event["queryStringParameters"]
    print(params)

    # extract vars
    brand = params.get("brand", "")
    title = params.get("title", "")
    amount = params.get("amount", "")
    price = params.get("price", "")
    pricePerAmount = params.get("pricePerAmount", "")

    # create api url
    base_api_url = 'http://ip-172-31-39-117.ap-northeast-2.compute.internal:10080/'
    search_api_url = f"api/v1/search?brand={brand}&title={title}&amount={amount}&price={price}&pricePerAmount={pricePerAmount}"
    api_url = base_api_url + search_api_url

    response = http.request("GET", api_url)
    return {
        'statusCode': 200,
        'body': response.data.decode('utf-8')
    }
